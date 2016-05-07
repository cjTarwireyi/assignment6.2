package com.example.cornelious.busbooking.Interfaces.employee;

import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.domain.employee.Employee;

/**
 * Created by Cornelious on 4/14/2016.
 */
public interface IEmployeeFactory {
    Employee createEmployee(Long employeeNumber,String empId, String name, String surname,EmpAddressVO objAddress);

}
