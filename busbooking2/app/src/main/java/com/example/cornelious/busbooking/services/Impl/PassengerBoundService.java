package com.example.cornelious.busbooking.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.Interfaces.passenger.IPassengerRepository;
import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.passenger.Passenger;
import com.example.cornelious.busbooking.domain.passenger.PassengerAddress;
import com.example.cornelious.busbooking.factories.passenger.PassengerAddressFactoryImpl;
import com.example.cornelious.busbooking.factories.passenger.PassengerFactoryImpl;
import com.example.cornelious.busbooking.repositories.passenger.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.services.IRequestPassangerService;
//A bound service is used because the user needs to inter act with the app and get results
public class PassengerBoundService extends Service implements IRequestPassangerService {

    private IBinder localBinder= new MylocalBinder();
    private IPassengerRepository objRepo;
    private  static PassengerBoundService service=null;

    public static PassengerBoundService getInstance()
    {
        if(service==null)
            service =new PassengerBoundService();
        return  service;
    }
    private PassengerBoundService() {
        objRepo= new PassengerRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
         return localBinder;
    }



    public class MylocalBinder extends Binder {
        public PassengerBoundService getService() {
            return PassengerBoundService.this;
        }
    }
@Override
    public String findPassenger(Long ticketNum ) {
        PassengerAddress objAddress= PassengerAddressFactoryImpl.createPassengerAddress("122cape","capeton","8000");
        Long id=new Long(1);
        Passenger objPassenger= PassengerFactoryImpl.createPassenger(id, "123", "cj", "Ta",objAddress);
        objRepo.add(objPassenger);
        Passenger addedPassenger =objRepo.findById(id);
        return addedPassenger.getLastName();


    }



}
