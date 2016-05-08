package com.example.cornelious.busbooking.services.Impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.booking.Ticket;
import com.example.cornelious.busbooking.repositories.booking.TicketRepoImpl;
import com.example.cornelious.busbooking.services.ITicketService;


//Intent service used so that the adding of records can be executed in the
// background in a queue in which the service will exit when done with the queue

public class TicketIntentService extends IntentService implements ITicketService{

    private static final String ACTION_ADD= "com.example.cornelious.busbooking.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.Impl.action.UPDATE";


    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.Impl.extra.UPDATE";

    TicketRepoImpl objRepo;
    private static  TicketIntentService service=null;

    public TicketIntentService getInstance(){
        if(service==null)
            service=new TicketIntentService();
        return  service;
    }

    private TicketIntentService() {
        super("TicketIntentService");
        objRepo = new TicketRepoImpl(App.getAppContext());
    }

     @Override
    public void addTicket(Context context,Ticket ticket) {
        Intent intent = new Intent(context, TicketIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, ticket);

        context.startService(intent);
    }


   @Override
    public  void updateTicket(Context context,Ticket ticket) {
        Intent intent = new Intent(context, TicketIntentService.class);
        intent.setAction(ACTION_UPDATE);

        intent.putExtra(EXTRA_UPDATE, ticket);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Ticket ticket =(Ticket) intent.getSerializableExtra(EXTRA_ADD);

                add(ticket);
            } else if (ACTION_UPDATE.equals(action)) {

                final Ticket ticket =(Ticket) intent.getSerializableExtra(EXTRA_UPDATE);
                update(ticket);
            }
        }
    }


    private void add(Ticket ticket) {
        objRepo.add(ticket);
    }


    private void update(Ticket ticket) {
         objRepo.update(ticket);
    }
}
