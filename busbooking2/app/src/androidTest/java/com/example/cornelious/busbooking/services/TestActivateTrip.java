package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;
import android.widget.Toast;

import com.example.cornelious.busbooking.domain.activatetrip.ActivateTrip;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.repositories.activatetrip.ActivateTripRepo;
import com.example.cornelious.busbooking.services.impl.ActivateTripBoundService;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class TestActivateTrip extends AndroidTestCase {
    private ActivateTripBoundService mService;
    private boolean status;
    ActivateTripRepo objRepo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getContext(),ActivateTripBoundService.class );
        App.getContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);
        status=true;
        Toast.makeText(getContext(), "service binded successfully", Toast.LENGTH_LONG).show();
    }
    public ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivateTripBoundService.LocalBinder binder =(ActivateTripBoundService.LocalBinder)service;
            mService=binder.getService();
            status=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            status=false;
        }
    };

    public void testBusAdded(){
        String status=mService.addTrip("cpt","2hrs","ec");

        Set<ActivateTrip> found= mService.find();
        Assert.assertEquals("New Trip Activated", status);

    }
}
