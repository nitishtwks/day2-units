package org.example.test;

import org.example.domain.Measurement;
import org.example.domain.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    void shouldEqualToMeasurement() throws IllegalAccessException {
        Measurement m1 = new Measurement(1, Unit.CM);
        Measurement m2 = new Measurement(1, Unit.CM);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldNotEqualToMeasurement() throws IllegalAccessException {
        Measurement m1 = new Measurement(1, Unit.CM);
        Measurement m2 = new Measurement(2, Unit.CM);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() throws IllegalAccessException {
        assertThrows(IllegalArgumentException.class, () ->  new Measurement(1, null));
    }

    @Test
    void shouldMeasurementInMEqualToCM() throws IllegalAccessException {
        Measurement m1 = new Measurement(1, Unit.M);
        Measurement m2 = new Measurement(100, Unit.CM);
        assertTrue(m1.equals(m2));
    }
    @Test
    void shouldMeasurementInCMEqualToKM() throws IllegalAccessException {
        Measurement m1 = new Measurement(100, Unit.CM);
        Measurement m2 = new Measurement(0.0001F, Unit.KM);
        assertFalse(m1.equals(m2));
    }

}
