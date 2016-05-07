package com.example.cornelious;



import com.example.cornelious.booking.TestBooking;
import com.example.cornelious.busTest.TestBusFactory;
import com.example.cornelious.employeetest.TestAddressFactory;
import com.example.cornelious.employeetest.TestEmployeeFactory;
import com.example.cornelious.passengertest.TestPassengerFactoryimpl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Cornelious on 4/16/2016.
 */

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            TestBooking.class,
            TestBusFactory.class,
            TestBusFactory.class,
            TestAddressFactory.class,
            TestEmployeeFactory.class,
            TestAddressFactory.class,
            TestPassengerFactoryimpl.class

    })
    public class AppSuitTest {
}
