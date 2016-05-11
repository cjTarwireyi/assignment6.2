package com.example.cornelious.busbooking.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.services.impl.PassengerIntentService;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestPassengerIService extends AndroidTestCase {
    private PassengerRepositoryImpl objRepo;
    private Intent intent;
    private PassengerIntentService service;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service=new PassengerIntentService();
//        intent=new Intent(App.getContext(),PassengerIntentService.class);
        objRepo= new PassengerRepositoryImpl(App.getContext());
    }
    public void testAdd(){

        PassengerAddress address=new PassengerAddress.AddressBuilder()
                .street("11 capeTown")
                .city("capetown")
                .code("8000")
                .build();
        Passenger passenger= new Passenger.PassengerBuilder()
                .name("cj")
                .lastName("cj")
                .id("1")
                .address(address)
                .build();

        service.addPassenger(App.getContext(), passenger);
        Set<Passenger> passengerSet=objRepo.findAll();
        Passenger found= objRepo.findById(1L);

        Assert.assertTrue("TEST ADD",passengerSet.size()>0);
        Assert.assertEquals(found.getObjAdress().getCity(),"capetown");
    }
}
