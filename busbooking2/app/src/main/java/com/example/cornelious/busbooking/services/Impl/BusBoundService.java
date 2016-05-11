package com.example.cornelious.busbooking.services.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.factories.Bus.BusFactoryImpl;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;

public class BusBoundService extends Service {
    private BusRepoImpl objrepo;
    private static BusBoundService service=null;



    public static BusBoundService getInstance(){
        if (service==null)
            service=new BusBoundService();
        return service;
    }
    private final IBinder localBinder = new MyLocalBinder();

    private BusBoundService() {
       // objrepo= new BusRepoImpl(App.getContext());
    }
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }
    public class MyLocalBinder extends Binder {
        public BusBoundService getService(){
            return  BusBoundService.this;
        }
    }
    public void addBus( String numplate,int id){
        Bus objBus= new Bus.BusBuilder()
                .getnumberPlate(numplate)
                .seats(2)
                .build();
        objrepo.add(objBus);
        //return "";
    }
    public String findBus(Long id ) {

        //Long id=new Long(1);
        Bus objBus= BusFactoryImpl.createBus("CA123",11);
        objrepo.add(objBus);
         Bus found= objrepo.findById(id);
        return found.getNumberPlate();


    }

}
