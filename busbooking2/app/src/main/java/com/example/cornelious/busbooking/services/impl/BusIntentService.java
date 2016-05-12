package com.example.cornelious.busbooking.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
import com.example.cornelious.busbooking.services.IBusIntentService;
//An Intent service is used because rhere is no need for a result to be returned to the caller
public class BusIntentService extends IntentService implements IBusIntentService {
     private final BusRepoImpl objRepo;
    private static BusIntentService service = null;

    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.action.UPDATE";


    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.extra.UPDATE";

    public BusIntentService getInstance(){
        if(service==null)
            service=new BusIntentService();
        return  service;
    }
    public BusIntentService() {
        super("BusIntentService");
        objRepo=new BusRepoImpl(App.getContext());
    }

@Override
     public void addBus(Context context,Bus bus) {
        Intent intent = new Intent(context, BusIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, bus);

        context.startService(intent);
    }

    @Override
    public void updateBus(Context context, Bus bus) {
        Intent intent = new Intent(context, BusIntentService.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, bus);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent!=null) {
            final String action = intent.getAction();
            if(ACTION_ADD.equals(action)) {
                final Bus objBus = (Bus) intent.getSerializableExtra(EXTRA_ADD);

            objRepo.add(objBus);
            }
            else{
                    final Bus objBus=(Bus)intent.getSerializableExtra(EXTRA_UPDATE);
                    objRepo.update(objBus);
                }
        }

    }
}
