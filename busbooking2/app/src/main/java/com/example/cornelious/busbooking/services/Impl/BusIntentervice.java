package com.example.cornelious.busbooking.services.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;


import com.example.cornelious.busbooking.Interfaces.bus.IBusRepositroy;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
import com.example.cornelious.busbooking.services.IBusService;


public class BusIntentervice extends IntentService implements IBusService {
    private final IBusRepositroy objBusRepo;
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.Impl.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.Impl.extra.UPDATE";

    private static BusIntentervice service=null;
    public static  BusIntentervice getInstance(){
        if(service==null)
            service=new BusIntentervice();
        return service;    }
    public BusIntentervice() {
        super("BusIntentervice");
        objBusRepo= new BusRepoImpl(App.getAppContext());
    }

    @Override
    public  void  addBus(Context context,Bus bus) {
        Intent intent = new Intent(context, BusIntentervice.class);
        intent.setAction(ACTION_ADD);
       intent.putExtra(EXTRA_UPDATE,bus);

        context.startService(intent);
    }


    public  void  updateBus(Context context,Bus bus) {
        Intent intent = new Intent(context, BusIntentervice.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, bus);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Bus objBus = (Bus) intent.getSerializableExtra(EXTRA_ADD);
                saveBus(objBus);

            } else if (ACTION_UPDATE.equals(action)) {
                final Bus objBus = (Bus) intent.getSerializableExtra(EXTRA_UPDATE);
                update(objBus);

            }
        }
    }

    private void saveBus(Bus objBus) {

    objBusRepo.add(objBus);
}

    private void update(Bus objBus) {
         objBusRepo.update(objBus);
    }
}
