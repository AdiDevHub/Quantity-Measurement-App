package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * Represents a physical length measurement.
 * This is an immutable Value Object.
 */
public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return this.conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "Unit cannot be null");
    }

    /**
     * Converts a raw value between units without instantiating an object.
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) throw new IllegalArgumentException("Units cannot be null");
        return (value * source.getConversionFactor()) / target.getConversionFactor();
    }

    /**
     * Instance method to convert current length to a new target unit.
     * Returns a NEW instance to maintain immutability.
     */
    public Length convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        // Compare using base unit normalization with small epsilon for double precision
        return Math.abs((this.value * this.unit.getConversionFactor()) -
                (other.value * other.unit.getConversionFactor())) < 1e-6;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public double getValue() { return value; }
}