package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.passenger.Passenger;

/**
 * Created by Cornelious on 5/7/2016.
 */
public interface IPassengerIntentService {
    void add(Context context,Passenger objPassenger);
    void update(Context context,Passenger objPassengrer);
}
