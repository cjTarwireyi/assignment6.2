package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.booking.Ticket;

/**
 * Created by Cornelious on 5/6/2016.
 */
public interface ITicketService {
    void addTicket(Context context,Ticket ticket);
    void updateTicket(Context context,Ticket ticket);
}
