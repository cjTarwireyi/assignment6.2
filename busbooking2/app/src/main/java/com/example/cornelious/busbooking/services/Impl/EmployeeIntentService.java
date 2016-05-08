package com.example.cornelious.busbooking.services.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.employee.Employee;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.repositories.employee.EmployeeRepoImpl;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.services.IEmployeeService;


//Intent service used so that the adding of records can be executed in the
// background in a queue in which the service will exit when done with the queue

public class EmployeeIntentService extends IntentService implements IEmployeeService {

    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.Impl.action.UPDATE";


    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.Impl.extra.UPDATE";

    EmployeeRepoImpl objRepo;
    private static EmployeeIntentService service =null;

    public static EmployeeIntentService getInstance(){
        if(service==null)
            service= new EmployeeIntentService();
        return  service;
    }
    private EmployeeIntentService() {
        super("EmployeeIntentService");
        objRepo= new EmployeeRepoImpl(App.getAppContext());
    }
@Override
    public  void addEmployee(Context context, Employee objEmployee) {
        Intent intent = new Intent(context, EmployeeIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, objEmployee);

        context.startService(intent);
    }

    @Override
    public  void updateEmployee(Context context, Employee objEmployee) {
        Intent intent = new Intent(context, EmployeeIntentService.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, objEmployee);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Employee objEmployee = (Employee)intent.getSerializableExtra(EXTRA_ADD);

                add(objEmployee);
            } else if (ACTION_UPDATE.equals(action)) {

                final Employee objEmployee =(Employee) intent.getSerializableExtra(EXTRA_UPDATE);
                update(objEmployee);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void add(Employee objEmployee) {
        objRepo.add(objEmployee);

    }

    private void update(Employee objEmployee) {
        objRepo.update(objEmployee);
    }
}
