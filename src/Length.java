package com.apps.quantitymeasurement;

public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double baseUnitFactor;

    LengthUnit(double baseUnitFactor) {
        this.baseUnitFactor = baseUnitFactor;
    }

    /**
     * Responsibility: Convert any value in THIS unit to the base unit (Feet).
     */
    public double convertToBaseUnit(double value) {
        return value * this.baseUnitFactor;
    }

    /**
     * Responsibility: Convert a value from the base unit (Feet) to THIS unit.
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.baseUnitFactor;
    }
}