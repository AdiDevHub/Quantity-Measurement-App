package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertEquals(feet1, feet2, "Two Feet objects with the same value should be equal.");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertNotEquals(feet1, feet2, "Two Feet objects with different values should not be equal.");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet = new Feet(1.0);
        assertNotEquals(null, feet, "A Feet object should not be equal to null.");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet = new Feet(1.0);
        Object notFeet = new Object();
        assertNotEquals(feet, notFeet, "A Feet object should not be equal to an object of a different type.");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet = new Feet(1.0);
        assertEquals(feet, feet, "A Feet object should be equal to itself (Reflexive).");
    }
}