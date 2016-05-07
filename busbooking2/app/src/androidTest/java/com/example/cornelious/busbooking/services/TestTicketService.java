package com.example.cornelious.busbooking.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.services.Impl.TicketService;

/**
 * Created by Cornelious on 5/6/2016.
 */
public class TestTicketService extends AndroidTestCase {
private TicketService objTicketService;
    private boolean isBound;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        objTicketService= TicketService.getInstance();
        Intent intent = new Intent(App.getAppContext(),TicketService.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection connection = new
            ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {

                    TicketService.ActivateLocalBinder binder =(TicketService.ActivateLocalBinder)service;
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

        String add=objTicketService.addPassenger(id,"1","cpt",2.0);
        //int answer=objTicketService.add(1,2);
       // Assert.assertNotSame("Ticket ADED",add);
    }
}
