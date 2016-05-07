package com.example.cornelious.busbooking.services;

import android.content.Context;

import com.example.cornelious.busbooking.domain.employee.Employee;
import com.example.cornelious.busbooking.domain.passenger.Passenger;

/**
 * Created by Cornelious on 5/7/2016.
 */
public interface IEmployeeService {
    void addEmployee(Context context,Employee objEmployee);
    void updateEmployee(Context context,Employee objEmployee);

}
