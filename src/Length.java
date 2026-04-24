package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0), INCHES(1.0), YARDS(36.0), CENTIMETERS(0.393701);

        private final double conversionFactor;
        LengthUnit(double factor) { this.conversionFactor = factor; }
        public double getConversionFactor() { return this.conversionFactor; }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "Unit required");
    }

    /**
     * Static add method: Adds two lengths and returns the result in the target unit.
     */
    public static Length add(Length l1, Length l2, LengthUnit targetUnit) {
        if (l1 == null || l2 == null) throw new IllegalArgumentException("Operands cannot be null");

        // Step 1: Convert both to base unit (Inches)
        double totalInches = (l1.value * l1.unit.getConversionFactor()) +
                (l2.value * l2.unit.getConversionFactor());

        // Step 2: Convert sum to target unit
        double resultValue = totalInches / targetUnit.getConversionFactor();

        return new Length(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        return Math.abs((this.value * this.unit.getConversionFactor()) -
                (other.value * other.unit.getConversionFactor())) < 1e-6;
    }

    @Override
    public String toString() { return String.format("%.2f %s", value, unit); }
}