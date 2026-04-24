package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "Unit required");
    }

    public QuantityLength convertTo(LengthUnit targetUnit) {
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityLength(convertedValue, targetUnit);
    }

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        double sumInBase = this.unit.convertToBaseUnit(this.value) +
                other.unit.convertToBaseUnit(other.value);
        return new QuantityLength(targetUnit.convertFromBaseUnit(sumInBase), targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityLength that = (QuantityLength) o;
        return Math.abs(this.unit.convertToBaseUnit(this.value) -
                that.unit.convertToBaseUnit(that.value)) < 1e-6;
    }

    @Override
    public String toString() { return String.format("%.2f %s", value, unit); }
}