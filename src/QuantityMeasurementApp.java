package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC8: Standalone Unit Responsibility ---");

        QuantityLength oneFoot = new QuantityLength(1.0, LengthUnit.FEET);

        // Delegation in action
        QuantityLength result = oneFoot.convertTo(LengthUnit.INCHES);
        System.out.println("Converted 1 Foot to: " + result);

        // Arithmetic delegation
        QuantityLength sum = oneFoot.add(new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.FEET);
        System.out.println("1 Foot + 12 Inches = " + sum);
    }
}