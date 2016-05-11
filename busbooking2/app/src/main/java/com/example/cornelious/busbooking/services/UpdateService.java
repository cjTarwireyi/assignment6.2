package com.example.cornelious.busbooking.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.example.cornelious.busbooking.Interfaces.employee.IEmployeeRepository;
import com.example.cornelious.busbooking.domain.employee.Employee;
import com.example.cornelious.busbooking.repositories.employee.EmployeeRepoImpl;


public class UpdateService extends Service {
    public UpdateService() {
    }
    private IEmployeeRepository objEmployeeRepo;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service is started",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);

    }
    public void createEmployee(String employeeId,String name,String surname){
        objEmployeeRepo= new EmployeeRepoImpl(this.getApplicationContext());

        Employee objEmployee = new Employee.EmployeeBuilder()
                .id(employeeId)
                .Name(name)
                .lastName(surname)
                .build();
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service is stopped",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

}
