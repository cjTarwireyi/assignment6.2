package com.example.cornelious.busbooking.booking;

import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.Interfaces.booking.ITicketRepo;
import com.example.cornelious.busbooking.domain.booking.Ticket;
import com.example.cornelious.busbooking.repositories.booking.TicketRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 4/23/2016.
 */
public class TestTicketBooking extends AndroidTestCase {
    private static final String TAG="TEST TICKET";
    private ITicketRepo objTicketRepo;
    private  Long id;

    public void testAddFindREmoveEdit(){
        objTicketRepo= new TicketRepoImpl(this.getContext());

        //CREATING
        Ticket objTicket=new Ticket.TicketBuilder()
                .ticketType("child")
                .route("CPT-JHB")
                .cost(700.00)
                .build();
        Ticket addedTicket=objTicketRepo.add(objTicket);
        id=addedTicket.getTicketNum();
        Assert.assertNotNull(TAG + " CREATING", addedTicket);

        //FIND BY ID
        Ticket objFound=objTicketRepo.findById(id);
        Assert.assertEquals(TAG + " FINDBY ID", "CPT-JHB", objFound.getRoute());

        //FIND ALL
        Set ticketSet =objTicketRepo.findAll();
        Assert.assertFalse(TAG + " FIND ALL", ticketSet.size() == 0);

        //DELETE
        objTicketRepo.remove(addedTicket);
        objFound=objTicketRepo.findById(id);
        Assert.assertNull(TAG + " DELETE", objFound);

        //DELETE ALL
        objTicketRepo.add(objTicket);
        ticketSet=objTicketRepo.findAll();
        Assert.assertNotNull(TAG + " BEFORE DELETE", ticketSet);
        objTicketRepo.removeAll();
        ticketSet=objTicketRepo.findAll();
        Assert.assertNull(TAG + " AFTER DELETE",ticketSet);


    }
}
