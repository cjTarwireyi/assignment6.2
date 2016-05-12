package com.example.cornelious.busbooking.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;
import com.example.cornelious.busbooking.services.impl.BusIntentService;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestBusIntentService extends AndroidTestCase {
    private  BusRepoImpl busRepo;
    private Intent intent;
    BusIntentService service;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Thread.sleep(1000);
    }
    public void testAddBus()throws  Exception{

        busRepo=new BusRepoImpl(this.getContext());
        intent = new Intent(App.getContext(), BusIntentService.class);
        service= new BusIntentService();
    //adding bus
Bus bus=new Bus.BusBuilder()

        .getnumberPlate("123")
        .seats(22)
        .build();
        service.addBus(App.getContext(), bus);
        Bus bus2= busRepo.findById(1L);
        Set<Bus> busSet=busRepo.findAll();

        Assert.assertTrue(busSet.size()>1);
        Assert.assertNotNull(bus2);

    }

   /* public void testUpdate()throws  Exception{
        Bus bus= new  Bus.BusBuilder()
               .copy(bus)
                .getnumberPlate("123")
                .build();
        service.updateBus(App.getContext(),bus);
    }*/

}
