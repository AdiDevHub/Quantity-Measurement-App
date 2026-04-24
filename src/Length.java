package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        // 1ft + 12in = 2ft. 2ft / 3ft per yard = 0.666...
        Length result = Length.add(l1, l2, LengthUnit.YARDS);
        assertEquals(0.666667, result.getValue(), 1e-6);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);
        // 2 inches in CM = 2 / 0.393701 = 5.080002
        Length result = Length.add(l1, l2, LengthUnit.CENTIMETERS);
        assertEquals(5.080002, result.getValue(), 1e-6);
    }

    @Test
    public void testAddition_NullTargetUnit_ThrowsException() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            Length.add(l1, l1, null);
        });
    }
}