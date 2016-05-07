package com.example.cornelious.busbooking.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.services.Impl.BusIntentervice;

/**
 * Created by Cornelious on 5/7/2016.
 */
public class TestBusService extends AndroidTestCase {
    private BusIntentervice objBusService;
    private Bus objBus;
    public void testBusService() {
        Long n= new Long(1);
        objBusService= BusIntentervice.getInstance();
        objBus=new Bus.BusBuilder()
                .busNumber(n)
                .getnumberPlate("b")
                .seats( 2 )
                .build();


        objBusService.addBus(App.getAppContext(),objBus);


    }



}
