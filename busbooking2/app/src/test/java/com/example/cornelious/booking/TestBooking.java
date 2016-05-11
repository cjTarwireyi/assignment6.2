package com.example.cornelious.booking;

import com.example.cornelious.busbooking.Interfaces.booking.ITicketFactory;
import com.example.cornelious.busbooking.domain.booking.Ticket;
import com.example.cornelious.busbooking.factories.booking.TicketFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class TestBooking {
    private ITicketFactory objTicketFactory;

    @Before
    public void setUp() throws Exception {
        objTicketFactory= new TicketFactoryImpl().getInstance();
    }

    @Test
    public void testTicketCreation() throws Exception {
        Ticket objTicket = objTicketFactory.createTicket(12,"Adult-Return","Cpt-Jhb",1000.00);
        Assert.assertEquals(12,objTicket.getTicketNum());
        Assert.assertEquals("Adult-Return",objTicket.getTicketType());
        Assert.assertEquals("Cpt-Jhb",objTicket.getRoute());
        Assert.assertEquals(1000.00,objTicket.getCost());

    }

    @Test
    public void testTicketUpdate() throws Exception {
        Ticket objTicket = objTicketFactory.createTicket(12,"Adult-Return","Cpt-Jhb",1000.00);
        Ticket newTicket=new Ticket.TicketBuilder()
                .copy(objTicket)
                .ticketNumber(13)
                .ticketType("Child-Single")
                .route("Pretoria-Dbn")
                .cost(400.00)
                .build();
        Assert.assertEquals(13,newTicket.getTicketNum());
        Assert.assertEquals("Child-Single",newTicket.getTicketType());
        Assert.assertEquals("Pretoria-Dbn",newTicket.getRoute());
        Assert.assertEquals(400.00,newTicket.getCost());

    }
}
