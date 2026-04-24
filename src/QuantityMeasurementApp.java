package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {
        System.out.println("--- UC4: Extended Unit Support Demo ---");

        // Yard to Feet
        System.out.println("1.0 Yard == 3.0 Feet: " +
                new Length(1.0, Length.LengthUnit.YARDS).equals(new Length(3.0, Length.LengthUnit.FEET)));

        // Yard to Inches
        System.out.println("1.0 Yard == 36.0 Inches: " +
                new Length(1.0, Length.LengthUnit.YARDS).equals(new Length(36.0, Length.LengthUnit.INCHES)));

        // Centimeters to Inches
        System.out.println("1.0 CM == 0.393701 Inches: " +
                new Length(1.0, Length.LengthUnit.CENTIMETERS).equals(new Length(0.393701, Length.LengthUnit.INCHES)));
    }
}