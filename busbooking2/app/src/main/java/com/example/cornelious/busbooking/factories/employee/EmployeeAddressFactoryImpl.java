package com.example.cornelious.busbooking.factories.employee;

import com.example.cornelious.busbooking.Interfaces.IAddressFactory;
import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;

/**
 * Created by Cornelious on 4/14/2016.
 */
public class EmployeeAddressFactoryImpl   {
    private static EmployeeAddressFactoryImpl objAddressFactory=null;
    public static EmployeeAddressFactoryImpl getInstance()
    {
        if (objAddressFactory==null)
            objAddressFactory=new EmployeeAddressFactoryImpl();
        return objAddressFactory;
    }

    public static EmpAddressVO createEmployeeAddress(Long id,String street, String city, String code){
        EmpAddressVO objAddress= new EmpAddressVO.AddressBuilder()
                .id(id)
                .street(street)
                .city(city)
                .code(code)
                .build();
        return objAddress;
        }


}
