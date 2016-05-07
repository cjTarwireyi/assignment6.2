package com.example.cornelious.busbooking.Interfaces.bus;

import com.example.cornelious.busbooking.domain.bus.Bus;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IBusFactory {
    Bus createBus(String numberPlate, int numberOfSeats);
}
