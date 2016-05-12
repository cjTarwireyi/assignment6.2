package com.example.cornelious.busbooking.repository;

import android.test.AndroidTestCase;

import com.example.cornelious.busbooking.Interfaces.bus.IMaintainanceRepo;
import com.example.cornelious.busbooking.domain.bus.Maintainance;
import com.example.cornelious.busbooking.repositories.bus.MaintainanceRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 4/23/2016.
 */
public class TestMaintainanceRepo extends AndroidTestCase{
    private  Long id;
    private static  final  String TAG="TEST MAINTAINANCE";
    private IMaintainanceRepo objMaintainanceRepo;

    public void testAddFindREmoveEdit(){

        objMaintainanceRepo=new MaintainanceRepoImpl(this.getContext());


        //CREATE
        Maintainance objMaintainance= new Maintainance.BuildMaintainance()
                .code("12")
                .Description("Tyres")
                .cost(500.00)
                .build();
       Maintainance addedMaintainance= objMaintainanceRepo.add(objMaintainance);
        id=addedMaintainance.getMaintainanceID();
        Assert.assertNotNull(TAG+" CREATE",addedMaintainance);
        Assert.assertEquals(TAG + " CREATE", 500.00, addedMaintainance.getCost());

        //FIND BY ID
        Maintainance foundMaintainance= objMaintainanceRepo.findById(id);
        Assert.assertNotNull(TAG + " FINDBY ID", foundMaintainance);

        //FIND ALL
        Set<Maintainance>maintainaceSet=objMaintainanceRepo.findAll();
        Assert.assertTrue(TAG + " FIND ALL", maintainaceSet.size() > 0);


        //DELETE
        Maintainance deleteThis = objMaintainanceRepo.findById(id);
        objMaintainanceRepo.remove(deleteThis);
        Maintainance findDeleted=objMaintainanceRepo.findById(id);
        Assert.assertNull(TAG + " DELETE", findDeleted);

        //DELETE ALL
        addedMaintainance= objMaintainanceRepo.add(objMaintainance);
        Assert.assertNotNull(TAG + " BEFORE DELETE ALL", addedMaintainance);
        objMaintainanceRepo.removeAll();
         maintainaceSet=objMaintainanceRepo.findAll();
        Assert.assertNull(TAG + " AFTER DELETE ALL", maintainaceSet);
    }
}
