package com.example.cornelious.passengertest;

import com.example.cornelious.busbooking.Interfaces.passenger.IPassengerFactory;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;
import com.example.cornelious.busbooking.factories.passenger.PassengerFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class TestPassengerFactoryimpl {
    private static IPassengerFactory objPassengerFactory;
    private PassengerAddress address;
    @Before
    public void setUp() throws Exception {
        objPassengerFactory= new PassengerFactoryImpl().getInstance();

    }

    @Test
    public void testPassengerCreation() throws Exception {
        Passenger objPassenger=objPassengerFactory.createPassenger(new Long(1),"123","Cornelious","Tarwireyi",address);
        Assert.assertEquals("123",objPassenger.getIdNumber());
        Assert.assertEquals("Cornelious",objPassenger.getName());
        Assert.assertEquals("Tarwireyi",objPassenger.getLastName());
    }

    @Test
    public void testPassengerUpdate() throws Exception {
        Passenger objPassenger=objPassengerFactory.createPassenger(new Long(0),"123","Cornelious","Tarwireyi",address);
        Passenger objNewPassenger= new Passenger.PassengerBuilder()
                .copy(objPassenger)
                .id("321")
                .name("cj")
                .lastName("junior")
                .build();
        Assert.assertEquals(objNewPassenger.getIdNumber(),"321");
        Assert.assertEquals(objNewPassenger.getName(),"cj");
        Assert.assertEquals(objNewPassenger.getLastName(),"junior");


    }
}
