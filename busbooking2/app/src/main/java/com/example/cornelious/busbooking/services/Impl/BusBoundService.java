package com.example.cornelious.busbooking.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.Interfaces.bus.IBusRepositroy;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.factories.Bus.BusFactoryImpl;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
//A bound service is used because the user needs to inter act with the app and get results
public class BusBoundService extends Service {
    private IBinder localBinder= new MyLocalBinder();
    private IBusRepositroy objrepo;
    private static BusBoundService service=null;


    private BusBoundService() {
        objrepo= new BusRepoImpl(App.getAppContext());
    }
    public static BusBoundService getInstance(){
        if (service==null)
            service=new BusBoundService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
    public class MyLocalBinder extends Binder{
        public BusBoundService getService(){
            return  BusBoundService.this;
        }
    }
    public String findBus(Long ticketNum ) {
        Long id=new Long(1);
        Bus objBus= BusFactoryImpl.createBus("CA123",11);
        objrepo.add(objBus);
        Bus addedBus = objrepo.findById(id);
        return addedBus.getNumberPlate();


    }
}
