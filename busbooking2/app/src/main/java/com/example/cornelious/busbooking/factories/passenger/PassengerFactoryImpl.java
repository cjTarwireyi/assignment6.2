package com.example.cornelious.busbooking.factories.passenger;

import com.example.cornelious.busbooking.Interfaces.passenger.IPassengerFactory;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class PassengerFactoryImpl  {
   private static PassengerFactoryImpl objPassengerFactory=null;
    public PassengerFactoryImpl getInstance()
    {
        if (objPassengerFactory==null)
            objPassengerFactory= new PassengerFactoryImpl();
        return objPassengerFactory;
    }

    public static Passenger createPassenger(Long passNumber,String passengerId, String passengerName, String passengerSurname,PassengerAddress obAddress) {
        Passenger objPassenger=new Passenger.PassengerBuilder()
                .passNumber(passNumber)
                .id(passengerId)
                .name(passengerName)
                .lastName(passengerSurname)
                .address(obAddress)
                .build();
        return objPassenger;
    }
}
