package com.example.cornelious.busbooking.services.Impl;

import android.content.Context;


import com.example.cornelious.busbooking.domain.bus.Maintainance;

/**
 * Created by Cornelious on 5/7/2016.
 */
public interface IMaintainanceService {
    void addMaintainance(Context context,Maintainance maintainance);
    void updateMaintainance(Context context,Maintainance maintainance);

}
