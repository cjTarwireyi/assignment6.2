package com.example.cornelious.busbooking.repository;

import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.domain.activatetrip.ActivateTrip;
import com.example.cornelious.busbooking.repositories.activatetrip.ActivateTripRepo;
import com.example.cornelious.busbooking.repositories.activatetrip.IActivateTripRepo;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class TestActivateTrip extends AndroidTestCase {
    private IActivateTripRepo objActivateRepo;
    private Long id;

    public void testAddFindREmoveEdit() {
        objActivateRepo = new ActivateTripRepo(this.getContext());
        ActivateTrip objTrip= new ActivateTrip.ActivateTripBuilder()
                .departure("departure")
                .time("time")
                .destination("destination")
                .build();
        objActivateRepo.add(objTrip);
        Set ticketSet =objActivateRepo.findAll();
        Assert.assertTrue( " FIND ALL", ticketSet.size() > 0);
    }
}
