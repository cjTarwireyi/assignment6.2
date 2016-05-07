package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.bus.Bus;

/**
 * Created by Cornelious on 5/7/2016.
 */
public interface IBusService {
    void addBus(Context context,Bus bus);
    void updateBus(Context context,Bus bus);
}
