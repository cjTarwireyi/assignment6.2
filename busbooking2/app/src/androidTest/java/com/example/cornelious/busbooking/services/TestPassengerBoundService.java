package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.PassengerBoundService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/8/2016.
 */
public class TestPassengerBoundService extends AndroidTestCase {
    private PassengerBoundService objPassengerservice;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        objPassengerservice = PassengerBoundService.getInstance();
        Intent intent = new Intent(App.getAppContext(), PassengerBoundService.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection connection = new
            ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    PassengerBoundService.MylocalBinder binder = (PassengerBoundService.MylocalBinder) service;
                    objPassengerservice = binder.getService();
                    isBound = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isBound = false;
                }
            };
    public void testPassengerAdded(){
        Long id= new Long(10);
        String lastName=objPassengerservice.findPassenger(id);
        Assert.assertEquals("Ta",lastName);
    }
}