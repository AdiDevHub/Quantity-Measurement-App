package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        System.out.println("--- UC7: Addition with Explicit Target Unit ---");

        Length oneFoot = new Length(1.0, LengthUnit.FEET);
        Length twelveInches = new Length(12.0, LengthUnit.INCHES);

        // 1ft + 12in requested in YARDS
        Length resultYards = Length.add(oneFoot, twelveInches, LengthUnit.YARDS);
        System.out.println("1ft + 12in in YARDS: " + resultYards); // Expected ~0.667 Yards

        // 1ft + 12in requested in INCHES
        Length resultInches = Length.add(oneFoot, twelveInches, LengthUnit.INCHES);
        System.out.println("1ft + 12in in INCHES: " + resultInches); // Expected 24.00 Inches
    }
}