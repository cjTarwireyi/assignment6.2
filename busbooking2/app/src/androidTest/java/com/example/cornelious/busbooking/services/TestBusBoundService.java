package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;
import android.widget.Toast;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
import com.example.cornelious.busbooking.services.impl.BusBoundService;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/11/2016.
 */
public class TestBusBoundService extends AndroidTestCase{
    private BusBoundService mService;
    private boolean status;
    BusRepoImpl objRepo;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        //
        Intent intent = new Intent(App.getContext(),BusBoundService.class );
        App.getContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);
        status=true;
        Toast.makeText(getContext(),"service binded successfully",Toast.LENGTH_LONG).show();


    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BusBoundService.LocalBinder binder =(BusBoundService.LocalBinder)service;
            mService=binder.getService();
            status=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            status=false;
        }
    };

    public void testBusAdded(){

        String status=mService.addBus();

        Set<Bus> found= mService.find();
        Assert.assertEquals("BUS ACTIVATED",status);
        Assert.assertTrue("TestADD"+found.size(),found.size()> 0);
        Assert.assertNotNull(mService.findById(1L));

    }

}
