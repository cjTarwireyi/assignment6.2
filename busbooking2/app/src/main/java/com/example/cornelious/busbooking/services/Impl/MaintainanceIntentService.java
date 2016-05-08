package com.example.cornelious.busbooking.services.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Maintainance;
import com.example.cornelious.busbooking.repositories.bus.MaintainanceRepoImpl;
import com.example.cornelious.busbooking.services.IMaintainanceService;


//Intent service used so that the adding of records can be executed in the
// background in a queue in which the service will exit when done with the queue

public class MaintainanceIntentService extends IntentService implements IMaintainanceService {

    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.Impl.action.UPDATE";


    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.Impl.extra.UPDATE";

    private MaintainanceRepoImpl objRepo;

    private static  MaintainanceIntentService service=null;

    public MaintainanceIntentService getInstance(){
        if(service==null)
            service=new MaintainanceIntentService();
        return  service;
    }
    public MaintainanceIntentService() {
        super("MaintainanceIntentService");
        objRepo= new MaintainanceRepoImpl(App.getAppContext());
    }

    @Override
    public void addMaintainance(Context context,Maintainance maintainance) {
        Intent intent = new Intent(context, MaintainanceIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, maintainance);
        context.startService(intent);
    }

     @Override
    public  void updateMaintainance(Context context,Maintainance maintainance) {
        Intent intent = new Intent(context, MaintainanceIntentService.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, maintainance);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Maintainance maintainance =(Maintainance) intent.getSerializableExtra(EXTRA_ADD);

                add(maintainance);
            } else if (ACTION_UPDATE.equals(action)) {
                final Maintainance maintainance = (Maintainance)intent.getSerializableExtra(EXTRA_UPDATE);
                update(maintainance);
            }
        }
    }


    private void add(Maintainance maintainance) {
        objRepo.add(maintainance);
    }

    private void update(Maintainance maintainance) {
         objRepo.update(maintainance);
    }
}
