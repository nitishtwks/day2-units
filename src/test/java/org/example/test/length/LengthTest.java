package org.example.test.length;

import org.example.domain.length.Length;
import org.example.domain.length.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    @Test
    void shouldEqualToMeasurement() {
        Length m1 = new Length(1, Unit.CM);
        Length m2 = new Length(1, Unit.CM);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldNotEqualToMeasurement() {
        Length m1 = new Length(1, Unit.CM);
        Length m2 = new Length(2, Unit.CM);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() {
        assertThrows(IllegalArgumentException.class, () ->  new Length(1, null));
    }

    @Test
    void shouldMeasurementInMEqualToCM() {
        Length m1 = new Length(1, Unit.M);
        Length m2 = new Length(100, Unit.CM);
        assertTrue(m1.equals(m2));
    }
    @Test
    void shouldMeasurementInCMEqualToKM() {
        Length m1 = new Length(100, Unit.CM);
        Length m2 = new Length(0.0001F, Unit.KM);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldAddTwoMeasurementsInMeters() {
        Length m1 = new Length(1, Unit.M);
        Length m2 = new Length(100, Unit.CM);
        Length m3 = m1.add(m2);
        Length expectedLength = new Length(2, Unit.M);
        assertTrue(m3.equals(expectedLength));
    }

    @Test
    void shouldAddTwoMeasurementsInCentimeters() {
        Length m1 = new Length(0, Unit.CM);
        Length m2 = new Length(1, Unit.M);
        Length m3 = m1.add(m2);
        Length expectedLength = new Length(100, Unit.CM);
        assertTrue(m3.equals(expectedLength));
    }

}
