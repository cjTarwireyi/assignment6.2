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
import com.example.cornelious.busbooking.services.ITicketService;


public class TicketService extends Service implements ITicketService {
    private IBinder localBinder= new ActivateLocalBinder();
    private ITicketRepo objRepo;
    private  static TicketService service=null;
    private TicketService() {
        objRepo  = new TicketRepoImpl(App.getAppContext());
    }
    public static  TicketService getInstance(){
        if(service==null)
            service= new TicketService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateLocalBinder extends Binder {
        public  TicketService getService(){
            return TicketService.this;
        }
    }
    @Override
    public String addPassenger(Long ticketNum, String ticketType, String route, double cost) {



            Ticket objTickect= TicketFactoryImpl.createTicket(ticketNum,ticketType,route,cost);

       objRepo.add(objTickect);
        return objTickect.getTicketType();


    }


    @Override
    public boolean isTicketAdded() {
        return false;
    }

    @Override
    public boolean isTicketRemoved() {
        return false;
    }


  /*  private Ticket createTicket(Ticket ticket){
        objRepo=new TicketRepoImpl(App.getAppContext());
        return objRepo.add(ticket);
    }*/





}
