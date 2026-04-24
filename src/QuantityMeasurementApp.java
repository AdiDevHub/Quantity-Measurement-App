package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        System.out.println("--- UC9: Weight Category Support ---");

        QuantityWeight oneKg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight thousandGrams = new QuantityWeight(1000.0, WeightUnit.GRAM);

        // Equality check
        System.out.println("1 kg equals 1000g: " + oneKg.equals(thousandGrams));

        // Cross-unit Addition
        QuantityWeight total = oneKg.add(new QuantityWeight(1.0, WeightUnit.POUND), WeightUnit.GRAM);
        System.out.println("1 kg + 1 lb in Grams: " + total);

        // Type Safety Check
        QuantityLength oneFoot = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println("1 kg equals 1 foot? " + oneKg.equals(oneFoot));
    }
}