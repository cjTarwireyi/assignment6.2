package com.example.cornelious.busbooking.factories.passenger;

import com.example.cornelious.busbooking.Interfaces.passenger.IPassengerFactory;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class PassengerFactoryImpl implements IPassengerFactory {
   private static PassengerFactoryImpl objPassengerFactory=null;
    public IPassengerFactory getInstance()
    {
        if (objPassengerFactory==null)
            objPassengerFactory= new PassengerFactoryImpl();
        return objPassengerFactory;
    }
    @Override
    public Passenger createPassenger(Long passNumber,String passengerId, String passengerName, String passengerSurname,PassengerAddress obAddress) {
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
