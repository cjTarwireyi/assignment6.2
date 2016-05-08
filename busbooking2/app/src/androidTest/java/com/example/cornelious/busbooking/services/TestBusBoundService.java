package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.BusBoundService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/8/2016.
 */
public class TestBusBoundService extends AndroidTestCase {
    private BusBoundService objBusService;
    private boolean isBound;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        objBusService= BusBoundService.getInstance();
        Intent intent = new Intent(App.getAppContext(),BusBoundService.class );
        App.getAppContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);
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
        Long id= new Long(10);
        String numberPlate= objBusService.findBus(id);

        Assert.assertEquals("CA123",numberPlate);
    }
}
