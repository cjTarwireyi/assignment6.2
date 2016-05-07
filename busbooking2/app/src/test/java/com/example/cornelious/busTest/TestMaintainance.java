package com.example.cornelious.busTest;

import com.example.cornelious.busbooking.Interfaces.bus.IBusMaintainanceFactory;
import com.example.cornelious.busbooking.domain.bus.Maintainance;
import com.example.cornelious.busbooking.factories.Bus.BusMaintainanceFactoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/17/2016.
 */
public class TestMaintainance {
    IBusMaintainanceFactory objMaintainanceFactory;

    @Before
    public void setUp() throws Exception {
        objMaintainanceFactory= new BusMaintainanceFactoryImpl().getInstance();

    }

    @Test
    public void testMaintainaceCreation() throws Exception {
        Maintainance objMaintainace=objMaintainanceFactory.createMaintainance("12","wheel puncture",400.00);
        Assert.assertEquals("12",objMaintainace.getMaintainanceCode());
        Assert.assertEquals("wheel puncture",objMaintainace.getDescription());
        Assert.assertEquals(400.00, objMaintainace.getCost(), 400.0);

    }

    @Test
    public void testMaintainanceUpdate() throws Exception {
        Maintainance objMaintainace=objMaintainanceFactory.createMaintainance("12","wheel puncture",400.00);
        Maintainance newMaintainace=  new Maintainance.BuildMaintainance()
                .copy(objMaintainace)
                .code("11")
                .Description("faulty plugs")
                .cost(200.00)
                .build();
        Assert.assertEquals("11",newMaintainace.getMaintainanceCode());
        Assert.assertEquals("faulty plugs",newMaintainace.getDescription());
        Assert.assertEquals(200.00,newMaintainace.getCost(),200);



    }
}
