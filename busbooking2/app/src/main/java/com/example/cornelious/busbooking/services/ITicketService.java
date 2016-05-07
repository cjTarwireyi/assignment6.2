package com.example.cornelious.busbooking.services;

/**
 * Created by Cornelious on 5/6/2016.
 */
public interface ITicketService {
    String addPassenger(Long ticketNum, String ticketType, String route, double cost);
    boolean isTicketAdded();
    boolean isTicketRemoved();
}
