package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.TicketBoundService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/6/2016.
 */
public class TestTicketBoundService extends AndroidTestCase {
    private TicketBoundService objTicketService;
    private boolean isBound;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        objTicketService= TicketBoundService.getInstance();
        Intent intent = new Intent(App.getAppContext(),TicketBoundService.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new
            ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {

                    TicketBoundService.MyLocalBinder binder =(TicketBoundService.MyLocalBinder)service;
                    objTicketService=binder.getService();
                    isBound= true;

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                    isBound=false;
                }
            };
    public void testTicketAdded() throws  Exception{
        Long id= new Long(10);
        String ticketType=objTicketService.findTicket(id);
        Assert.assertNotSame("Adult",ticketType);
    }
}
