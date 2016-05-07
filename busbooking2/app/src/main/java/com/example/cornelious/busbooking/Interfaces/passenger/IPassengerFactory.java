package com.example.cornelious.busbooking.Interfaces.passenger;

import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IPassengerFactory {
    Passenger createPassenger(Long passNumber,String passengerId, String passengerName, String passengerSurname,PassengerAddress obAddress);
}
