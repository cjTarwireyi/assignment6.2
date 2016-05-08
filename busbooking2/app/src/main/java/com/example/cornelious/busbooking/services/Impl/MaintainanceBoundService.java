package com.example.cornelious.busbooking.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.cornelious.busbooking.config.App;
import com.example.cornelious.busbooking.domain.bus.Maintainance;
import com.example.cornelious.busbooking.factories.Bus.BusMaintainanceFactoryImpl;
import com.example.cornelious.busbooking.repositories.bus.MaintainanceRepoImpl;
//A bound service is used because the user needs to inter act with the app and get results
public class MaintainanceBoundService extends Service {
    private IBinder localBinder = new MyLocalBinder();
    private MaintainanceRepoImpl objRepo;
    private static MaintainanceBoundService service = null;

    public MaintainanceBoundService() {
        objRepo = new MaintainanceRepoImpl(App.getAppContext());
    }

    public static MaintainanceBoundService getInstance() {
        if (service == null)
            service = new MaintainanceBoundService();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class MyLocalBinder extends Binder {
        public MaintainanceBoundService getService() {
            return MaintainanceBoundService.this;
        }
    }

    public String findTicket(Long ticketNum) {
        Long id = new Long(1);
        Maintainance maintainance = BusMaintainanceFactoryImpl.createMaintainance(id, "brakes", "replacement", 100.00);
        objRepo.add(maintainance);
        Maintainance addedmaintainance = objRepo.findById(id);
        return addedmaintainance.getDescription();
    }
}