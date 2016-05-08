package com.example.cornelious.busbooking.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.Interfaces.booking.ITicketRepo;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.booking.Ticket;
import com.example.cornelious.busbooking.factories.booking.TicketFactoryImpl;
import com.example.cornelious.busbooking.repositories.booking.TicketRepoImpl;

//A bound service is used because the user needs to inter act with the app and get results
public class TicketBoundService extends Service  {
    private IBinder localBinder= new MyLocalBinder();
    private ITicketRepo objRepo;
    private  static TicketBoundService service=null;
    private TicketBoundService() {
        objRepo  = new TicketRepoImpl(App.getAppContext());
    }
    public static TicketBoundService getInstance(){
        if(service==null)
            service= new TicketBoundService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class MyLocalBinder extends Binder {
        public TicketBoundService getService(){
            return TicketBoundService.this;
        }
    }

    public String findTicket(Long ticketNum ) {
            Long id=new Long(1);
            Ticket objTickect= TicketFactoryImpl.createTicket(id,"adult","CPT-JHB",100.00);
            objRepo.add(objTickect);
            Ticket addedTicket =objRepo.findById(id);
            return addedTicket.getTicketType();


    }

}
