package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    /**
     * Overloaded method 1: Converts raw numeric values
     */
    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = Length.convert(value, from, to);
        System.out.printf("Convert Raw: %.2f %s -> %.2f %s%n", value, from, result, to);
    }

    /**
     * Overloaded method 2: Converts an existing Length object
     */
    public static void demonstrateLengthConversion(Length length, LengthUnit to) {
        Length result = length.convertTo(to);
        System.out.printf("Convert Object: %s -> %s%n", length, result);
    }

    public static void main(String[] args) {
        System.out.println("--- UC5: Unit-to-Unit Conversion Demo ---");

        // Demo Overloading
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);

        Length yardObj = new Length(1.0, LengthUnit.YARDS);
        demonstrateLengthConversion(yardObj, LengthUnit.FEET);

        // Demo CM to Inches
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
    }
}