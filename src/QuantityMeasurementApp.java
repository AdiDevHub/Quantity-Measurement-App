package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityMeasurementApp {

    // Step 1: Enum to handle units and conversion factors
    public enum LengthUnit {
        FEET(12.0), INCHES(1.0);

        public final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
    }

    // Step 2: Unified Length Class
    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Length other = (Length) obj;

            // Convert both to a base unit (Inches) for comparison
            double value1 = this.value * this.unit.conversionFactor;
            double value2 = other.value * other.unit.conversionFactor;

            return Double.compare(value1, value2) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, unit);
        }
    }

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateFeetEquality() {
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);
        System.out.println("1.0 ft and 1.0 ft: " + demonstrateLengthEquality(f1, f2));
    }

    public static void demonstrateInchesEquality() {
        Length i1 = new Length(1.0, LengthUnit.INCHES);
        Length i2 = new Length(1.0, LengthUnit.INCHES);
        System.out.println("1.0 inch and 1.0 inch: " + demonstrateLengthEquality(i1, i2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        System.out.println("1.0 ft and 12.0 inches: " + demonstrateLengthEquality(feet, inches));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}