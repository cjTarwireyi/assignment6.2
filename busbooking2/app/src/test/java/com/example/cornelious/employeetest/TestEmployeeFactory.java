package com.example.cornelious.employeetest;

import com.example.cornelious.busbooking.Interfaces.employee.IEmployeeFactory;
import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.domain.employee.Employee;
import com.example.cornelious.busbooking.factories.employee.EmployeeFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/15/2016.
 */
public class TestEmployeeFactory {
  private IEmployeeFactory objEmployeeFactory;
    private EmpAddressVO objAddress;

    @Before
    public void setUp() throws Exception {
    objEmployeeFactory=  new EmployeeFactoryImpl().getInstance();

    }

    @Test
    public void testEmployeeCreation() throws Exception {
       Employee objEmployee=objEmployeeFactory.createEmployee(new Long(1),"1234567891230","Cornelious","Tarwireyi",objAddress);


       Assert.assertEquals("1234567891230",objEmployee.getEmpId());
       Assert.assertEquals("Cornelious",objEmployee.getEmpName());
       Assert.assertEquals("Tarwireyi",objEmployee.getEmpLastName());
    }

    @Test
    public void testEmployeeUpdate() throws Exception {
        Employee objEmployee= objEmployeeFactory.createEmployee(new Long(1),"1234567891230","Cornelious","Tarwireyi",objAddress);
        Employee newEmployee= new Employee.EmployeeBuilder()
                .copy(objEmployee)
                .id("123")
                .Name("cj")
                .lastName("junior")
                .build();
        Assert.assertEquals("123",newEmployee.getEmpId());
        Assert.assertEquals("cj",newEmployee.getEmpName());
        Assert.assertEquals("junior",newEmployee.getEmpLastName());


    }
}
