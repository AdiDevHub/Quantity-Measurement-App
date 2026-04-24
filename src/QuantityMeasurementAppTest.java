package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_FeetAndInches_ReturnsFeet() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        Length expected = new Length(2.0, LengthUnit.FEET);
        assertEquals(expected, Length.add(l1, l2, LengthUnit.FEET));
    }

    @Test
    public void testAddition_InchesAndFeet_ReturnsInches() {
        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.FEET);
        Length expected = new Length(24.0, LengthUnit.INCHES);
        assertEquals(expected, Length.add(l1, l2, LengthUnit.INCHES));
    }

    @Test
    public void testAddition_Commutativity() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        Length res1 = Length.add(l1, l2, LengthUnit.INCHES);
        Length res2 = Length.add(l2, l1, LengthUnit.INCHES);

        assertEquals(res1, res2, "Addition should be commutative");
    }

    @Test
    public void testAddition_WithZeroValue() {
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(0.0, LengthUnit.INCHES);
        assertEquals(l1, Length.add(l1, l2, LengthUnit.FEET));
    }
}