package com.example.cornelious.busbooking.Interfaces;

import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;

/**
 * Created by Cornelious on 4/15/2016.
 */
public abstract class IAddressFactory {
     public PassengerAddress createPassengerAddress(String street, String city, String code){return null;};

     public EmpAddressVO createEmployeeAddress(Long id,String street, String city, String code){return null;};
}
