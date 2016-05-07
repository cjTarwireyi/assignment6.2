package com.example.cornelious.employeetest;

import com.example.cornelious.busbooking.Interfaces.IAddressFactory;
import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.factories.employee.EmployeeAddressFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class TestAddressFactory {
    private IAddressFactory objAddressFactory;

    @Before
    public void setUp() throws Exception {
        objAddressFactory=  EmployeeAddressFactoryImpl.getInstance();
    }

    @Test
    public void testAddressCreation() throws Exception {

        EmpAddressVO objAddress=objAddressFactory.createEmployeeAddress((new Long(1)),"199 Solaria","Muizenberg","7945");
        Assert.assertEquals("199 Solaria",objAddress.getStreet());
        Assert.assertEquals("Muizenberg",objAddress.getCity());
        Assert.assertEquals("7945",objAddress.getCode());
    }

    @Test
    public void testAddressUpdate() throws Exception {
        EmpAddressVO objAddress=objAddressFactory.createEmployeeAddress(new Long(1),"199 Solaria","Muizenberg","7945");
        EmpAddressVO newAdress= new EmpAddressVO
                .AddressBuilder()
                .copy(objAddress)
                .street("79 OysterBay")
                .city("Fishhoek")
                .code("8000")
                .build();
        Assert.assertEquals("79 OysterBay", newAdress.getStreet());
        Assert.assertEquals("Fishhoek",newAdress.getCity());
        Assert.assertEquals("8000",newAdress.getCode());


    }
}
