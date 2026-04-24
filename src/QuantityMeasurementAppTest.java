package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertEquals(yard, inches);
    }

    @Test
    public void centimeterEqualsInches() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, LengthUnit.INCHES);
        assertEquals(cm, inches);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertEquals(new Length(3.0, LengthUnit.FEET), new Length(1.0, LengthUnit.YARDS));
    }

    @Test
    public void testTransitiveProperty() {
        Length a = new Length(1.0, LengthUnit.YARDS);
        Length b = new Length(3.0, LengthUnit.FEET);
        Length c = new Length(36.0, LengthUnit.INCHES);

        assertEquals(a, b);
        assertEquals(b, c);
        assertEquals(a, c); // Transitive check
    }
}