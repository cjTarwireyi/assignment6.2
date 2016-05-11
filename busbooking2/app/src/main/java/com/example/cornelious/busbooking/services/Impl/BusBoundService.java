package com.example.cornelious.busbooking.services.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.cornelious.busbooking.Interfaces.bus.IBusRepositroy;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.factories.Bus.BusFactoryImpl;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;

import java.util.Set;

public class BusBoundService extends Service {
     private final IBinder mBinder= new LocalBinder();
    private final IBusRepositroy objRepo;
     private static BusBoundService service= null;
    public static BusBoundService getInstance(){
        if (service==null)
            service=new BusBoundService();
        return service;
    }
    private final IBinder localBinder = new LocalBinder ();

    public BusBoundService() {
        objRepo= new BusRepoImpl(App.getContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder{
        public BusBoundService getService(){
            return BusBoundService.this;
        }
    }


    public String addBus( ){
        Bus objBus= new Bus.BusBuilder()
                .getnumberPlate("numplate")
                .seats(2)
                .build();
        Bus savedBus=objRepo.add(objBus);
      if(savedBus!=null){
        return "BUS ACTIVATED";
      }
        else{
          return"NOT ACTIVATED";
      }
    }
    public Set<Bus> find(){
        Set<Bus> busSet= objRepo.findAll();
        return busSet;
    }
    public Bus findById(Long id){
        return objRepo.findById(id);
    }

}
