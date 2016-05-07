package com.example.cornelious.busbooking.Interfaces.employee;



import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;

/**
 * Created by Cornelious on 4/17/2016.
 */
public interface IEmployeeAddressRepository {
    EmpAddressVO addAddress (String key, EmpAddressVO objAddress);
    EmpAddressVO findAddress(String key);
    EmpAddressVO remove(String key);
}
