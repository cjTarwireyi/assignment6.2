package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.passenger.Passenger;

/**
 * Created by Cornelious on 5/10/2016.
 */
public interface IPassengerService {
    void addPassenger(Context context,Passenger passenger);
    void updatePassenger(Context context,Passenger passenger);
}
