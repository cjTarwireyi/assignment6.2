package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
import com.example.cornelious.busbooking.services.impl.BusBoundService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/11/2016.
 */
public class TestBusBoundService extends AndroidTestCase{
    private BusBoundService objBusService;
    private boolean isBound;
    BusRepoImpl objRepo;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        //
        Intent intent = new Intent(App.getContext(),BusBoundService.class );
        App.getContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BusBoundService.MyLocalBinder binder=(BusBoundService.MyLocalBinder)service;
            objBusService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

    public void testBusAdded(){
        objRepo= new BusRepoImpl(App.getContext());
        Long id= new Long(10);
        Bus bus=new Bus.BusBuilder()
                .seats(2)
                .getnumberPlate("123")
                .build();
      // objBusService.findBus(0L);
        objBusService.findBus(0L);

        //Assert.assertEquals("CA123", objRepo.findById(0L));
    }

}
