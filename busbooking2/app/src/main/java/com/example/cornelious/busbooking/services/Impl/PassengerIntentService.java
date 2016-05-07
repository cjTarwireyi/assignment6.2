package com.example.cornelious.busbooking.services.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.services.IPassengerIntentService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class PassengerIntentService extends IntentService implements IPassengerIntentService {
    private PassengerRepositoryImpl objRepo;
    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.passenger.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.passenger.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.passenger.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.passenger.extra.UPDATE";

    private static PassengerIntentService service=null;
    public static  PassengerIntentService getInstance(){
        if(service==null)
            service=new PassengerIntentService();
        return service;
    }

    private PassengerIntentService() {
        super("PassengerIntentService");
        objRepo= new PassengerRepositoryImpl(App.getAppContext());
    }

     @Override
    public void add(Context context,Passenger objPassenger) {
        Intent intent = new Intent(context, PassengerIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, objPassenger);

        context.startService(intent);
    }


    @Override
    public void update(Context context,Passenger objPassenger) {
        Intent intent = new Intent(context, PassengerIntentService.class);
        intent.setAction(ACTION_UPDATE);

        intent.putExtra(EXTRA_UPDATE, objPassenger);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Passenger objPassenger =(Passenger) intent.getSerializableExtra(EXTRA_ADD);

                addPassenger(objPassenger);
            } else if (ACTION_UPDATE.equals(action)) {

                final Passenger objPassenger =(Passenger) intent.getSerializableExtra(EXTRA_UPDATE);
                updatePassenger(objPassenger);
            }
        }
    }

    private void addPassenger(Passenger objPassenger) {
       objRepo.add(objPassenger);
    }
    private void updatePassenger(Passenger objPassenger) {

        objRepo.update(objPassenger);
    }
}
