package com.apps.quantitymeasurement;

public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double baseUnitFactor;

    WeightUnit(double baseUnitFactor) {
        this.baseUnitFactor = baseUnitFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * this.baseUnitFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.baseUnitFactor;
    }
}