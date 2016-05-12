package com.example.cornelious.busbooking.factories.activatetrip;

import com.example.cornelious.busbooking.domain.activatetrip.ActivateTrip;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class ActivateTripServiceFactory {
    private static ActivateTripServiceFactory activateTripServiceFactory=null;

    public static  ActivateTripServiceFactory getInstance(){
        if (activateTripServiceFactory==null)
            activateTripServiceFactory=new ActivateTripServiceFactory();
        return  activateTripServiceFactory;
    }
    public ActivateTrip createTrip(String depature,String time, String destination){
        ActivateTrip activateTrip= new ActivateTrip.ActivateTripBuilder()
                .departure(depature)
                .time(time)
                .destination(destination)
                .build();
        return activateTrip;

    }
}
