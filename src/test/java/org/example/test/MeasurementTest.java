package org.example.test;

import org.example.domain.Measurement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    void shouldEqualToMeasurement() throws IllegalAccessException {
        Measurement m1 = new Measurement(1, "cm");
        Measurement m2 = new Measurement(1, "cm");
        assertTrue(m1.isEqualTo(m2));
    }

    @Test
    void shouldNotEqualToMeasurement() throws IllegalAccessException {
        Measurement m1 = new Measurement(1, "cm");
        Measurement m2 = new Measurement(2, "cm");
        assertFalse(m1.isEqualTo(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() throws IllegalAccessException {
        assertThrows(IllegalArgumentException.class, () ->  new Measurement(1, null));
    }
}
