package com.thoughtworks.bootcamp.mesurement;

import org.junit.Test;

import static com.thoughtworks.bootcamp.mesurement.MeasurementType.*;
import static org.junit.Assert.*;

/**
 * Created by deepak on 31/5/16.
 */
public class MeasurementTypeTest {


    @Test
    public void testConvert() throws Exception {
        assertTrue(Ounce.convert(8, Cup) == 1);
    }





    @Test
    public void testQuantityEqual() throws Exception {
        assertTrue(Teaspoon.isEqual(3,3,Teaspoon));
        assertTrue(TableSpoon.isEqual(1,3,Teaspoon));
        assertTrue(Teaspoon.isEqual(3,1,TableSpoon));
        assertTrue(Teaspoon.isEqual(3,1,TableSpoon));
        assertTrue(Teaspoon.isEqual(3,1,TableSpoon));
        assertTrue(Cup.isEqual(1,8,Ounce));
        assertTrue(Ounce.isEqual(1,2,TableSpoon));
        assertTrue(Pint.isEqual(1,2,Cup));
        assertTrue(Quart.isEqual(1,4,Cup));
        assertTrue(Gallon.isEqual(1,4,Quart));


    }
    @Test
    public void testGetFactor() throws Exception {
        assertTrue(Gallon.getFactor(Quart)==4);
        assertTrue(Quart.getFactor(Cup)==4);
    }


}