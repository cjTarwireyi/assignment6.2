package com.example.cornelious.busbooking.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.domain.employee.EmpAddressVO;
import com.example.cornelious.busbooking.domain.employee.Employee;
import com.example.cornelious.busbooking.factories.employee.EmployeeAddressFactoryImpl;
import com.example.cornelious.busbooking.factories.employee.EmployeeFactoryImpl;
import com.example.cornelious.busbooking.repositories.employee.EmployeeRepoImpl;
//A bound service is used because the user needs to inter act with the app and get results
public class EmployeeBoundService extends Service {
    private IBinder localBinder = new MyLocalBinder();
    private static EmployeeBoundService service= null;

    public static EmployeeBoundService getInstance(){
        if(service== null)
            service=new EmployeeBoundService();
        return  service;
    }
    private EmployeeRepoImpl objRepo;
    public EmployeeBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return localBinder;
    }
    public class MyLocalBinder extends Binder {
        public EmployeeBoundService getService(){
            return EmployeeBoundService.this;
        }

    }
    public String findEmployee(Long ticketNum ) {
        Long id=new Long(1);
        EmpAddressVO address= EmployeeAddressFactoryImpl.createEmployeeAddress(id,"122cape","capeton","8000");
        Employee objEmployee= EmployeeFactoryImpl.createEmployee(id, "cj", "cj", "cj",address);
        objRepo.add(objEmployee);
        Employee addedEmployee =objRepo.findById(id);
        return addedEmployee.getEmpLastName();


    }
}
