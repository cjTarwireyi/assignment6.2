package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.activatetrip.ActivateTrip;

/**
 * Created by Cornelious on 5/12/2016.
 */
public interface IActivateTripService {
    public void addTrip(Context context,ActivateTrip activateTrip);
    public  void updateTrip(Context context,ActivateTrip activateTrip);
}
