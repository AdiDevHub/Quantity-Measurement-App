package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Finite value required");
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "Unit required");
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        double baseValue = this.unit.convertToBaseUnit(this.value);
        return new QuantityWeight(targetUnit.convertFromBaseUnit(baseValue), targetUnit);
    }

    // Overloaded Add (Implicit Target)
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // Overloaded Add (Explicit Target)
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        double sumInBase = this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);
        return new QuantityWeight(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Category Type Safety: Reject if comparing Weight to Length
        if (o == null || getClass() != o.getClass()) return false;

        QuantityWeight that = (QuantityWeight) o;
        return Math.abs(this.unit.convertToBaseUnit(this.value) -
                that.unit.convertToBaseUnit(that.value)) < 1e-6;
    }

    @Override
    public int hashCode() { return Objects.hash(value, unit); }

    @Override
    public String toString() { return String.format("%.3f %s", value, unit); }
}