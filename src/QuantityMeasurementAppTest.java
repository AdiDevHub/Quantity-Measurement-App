package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    private final double EPSILON = 1e-6;

    @Test
    public void testFeetToInchesConversion() {
        assertEquals(12.0, Length.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testInchesToYardsConversion() {
        assertEquals(1.0, Length.convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS), EPSILON);
    }

    @Test
    public void testCentimetersToInchesConversion() {
        assertEquals(0.393701, Length.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testZeroValueConversion() {
        assertEquals(0.0, Length.convert(0.0, LengthUnit.YARDS, LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testRoundTrip_PreservesValue() {
        double original = 10.5;
        double toInches = Length.convert(original, LengthUnit.FEET, LengthUnit.INCHES);
        double backToFeet = Length.convert(toInches, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(original, backToFeet, EPSILON);
    }

    @Test
    public void testInvalidValue_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));
    }
}