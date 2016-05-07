package com.example.cornelious.busbooking.bus;

import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.Interfaces.bus.IBusRepositroy;
import com.example.cornelious.busbooking.domain.bus.Bus;
import com.example.cornelious.busbooking.repositories.bus.BusRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 4/22/2016.
 */
public class TestBusRepo extends AndroidTestCase {
    private static final String TAG="BUS TEST";
    private Long busNum;
    private IBusRepositroy busRepo;

    public void testAddFindREmoveEdit(){
        busRepo=new BusRepoImpl(this.getContext());

        //CREATE
        Bus objBus=new Bus.BusBuilder()
                .getnumberPlate("CA123")
                .seats(72)
                .build();
        Bus createdBus=busRepo.add(objBus);
        busNum=createdBus.getBusNumber();
        Assert.assertNotNull(TAG + " CREATE", createdBus);

        //FIND BY ID
        Bus foundBus=busRepo.findById(busNum);
        Assert.assertNotNull(TAG + " FINDBY ID", foundBus);

        //FIND ALL
        Set busSet=busRepo.findAll();
        Assert.assertTrue(TAG + " FIND ALL", busSet.size() > 0);
        //UPDATE
        Bus updateBus= new Bus.BusBuilder()
                .copy(foundBus)
                .seats(50)
                .build();
        busRepo.update(updateBus);
        Bus newBus=busRepo.findById(busNum);
        Assert.assertEquals(TAG + " UPDATE", 50, newBus.getSeats());

        //DELETE
        busRepo.remove(updateBus);
        Bus objBusDeleted= busRepo.findById(busNum);
        Assert.assertNull(TAG + " DELETE", objBusDeleted);

        //DELETE ALL
        busRepo.removeAll();
        Set allBuses=busRepo.findAll();
        Assert.assertTrue(TAG+" DELETE ALL",allBuses.size()==0);

    }
}
