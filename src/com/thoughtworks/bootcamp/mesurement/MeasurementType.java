package com.thoughtworks.bootcamp.mesurement;

/**
 * Created by deepak on 31/5/16.
 */
public enum MeasurementType {
    Teaspoon(1),
    TableSpoon(3),
    Ounce(6),
    Cup(48),
    Pint(96),
    Quart(192),
    Gallon(768);

    private final int conversionFactor;

    MeasurementType(int conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public float convert(int thisQuantity, MeasurementType thatSpoonType){
        return (float)(thisQuantity * this.conversionFactor)/thatSpoonType.conversionFactor;
    }














    public boolean isEqual(int quantity1, int quantity2, MeasurementType thatSpoonType){
        return this.conversionFactor*quantity1 == quantity2*thatSpoonType.conversionFactor;

    }
    public float getFactor(MeasurementType thatSpoonType){
        return this.conversionFactor/thatSpoonType.conversionFactor;

    }

}

