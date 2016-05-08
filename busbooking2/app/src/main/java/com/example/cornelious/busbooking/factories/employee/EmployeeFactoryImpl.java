package com.example.cornelious.busbooking.factories.employee;

import com.example.cornelious.busbooking.Interfaces.employee.IEmployeeFactory;
import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.domain.employee.Employee;

/**
 * Created by Cornelious on 4/15/2016.
 */
public class EmployeeFactoryImpl  {
    private static EmployeeFactoryImpl objEmpFactory=null;

    public EmployeeFactoryImpl getInstance()
    {
        if (objEmpFactory==null)
            objEmpFactory=new EmployeeFactoryImpl();
        return objEmpFactory;
    }


    public static Employee createEmployee(Long employeeNumber,String empId, String empName, String empSurname,EmpAddressVO objAddress) {
        Employee objEmployee = new Employee.EmployeeBuilder()
                .employeeNumber(employeeNumber)
                .id(empId)
                .Name(empName)
                .lastName(empSurname)
                .address(objAddress)
                .build();
        return objEmployee;
    }
}
