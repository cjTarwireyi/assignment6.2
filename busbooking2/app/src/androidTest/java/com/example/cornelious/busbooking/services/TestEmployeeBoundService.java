package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.EmployeeBoundService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/8/2016.
 */
public class TestEmployeeBoundService extends AndroidTestCase {
    private EmployeeBoundService objEmployeeService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        Intent intent = new Intent(App.getAppContext(), EmployeeBoundService.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EmployeeBoundService.MyLocalBinder binder=(EmployeeBoundService.MyLocalBinder)service;
            objEmployeeService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;

        }
    };
public void testAddedEmployee(){
    Long id= new Long(10);
    String lastname=objEmployeeService.findEmployee(id);
    Assert.assertEquals("cj",lastname);

}
}
