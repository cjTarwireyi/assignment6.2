package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.MaintainanceBoundService;

import org.junit.Assert;

/**
 * Created by Cornelious on 5/8/2016.
 */
public class TestMaintainanceBoundService extends AndroidTestCase {
    private MaintainanceBoundService objMaintainanceService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(),MaintainanceBoundService.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MaintainanceBoundService.MyLocalBinder binder=(MaintainanceBoundService.MyLocalBinder)service;
            objMaintainanceService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };
    public void testAddedMantainance(){
        Long id= new Long(10);
        String maintainance=objMaintainanceService.findTicket(id);
        Assert.assertSame("replacement",maintainance);
    }
}
