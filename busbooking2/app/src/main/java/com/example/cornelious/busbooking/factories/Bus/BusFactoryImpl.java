package com.example.cornelious.busbooking.factories.Bus;

import com.example.cornelious.busbooking.Interfaces.bus.IBusFactory;
import com.example.cornelious.busbooking.domain.bus.Bus;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class BusFactoryImpl implements IBusFactory {
    private static BusFactoryImpl objBusFactory=null;
    public BusFactoryImpl getInstance()
    {
        if (objBusFactory==null)
            objBusFactory= new BusFactoryImpl();
        return objBusFactory;
    }
    @Override
    public Bus createBus(String numberPlate, int numberOfSeats) {
        Bus objBus= new Bus.BusBuilder()
                .getnumberPlate(numberPlate)
                .seats(numberOfSeats)
                .build();
        return objBus;
    }
}
