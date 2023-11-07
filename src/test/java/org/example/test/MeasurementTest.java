package org.example.test;

import org.example.domain.Measurement;
import org.example.domain.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    void shouldEqualToMeasurement() {
        Measurement m1 = new Measurement(1, Unit.CM);
        Measurement m2 = new Measurement(1, Unit.CM);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldNotEqualToMeasurement() {
        Measurement m1 = new Measurement(1, Unit.CM);
        Measurement m2 = new Measurement(2, Unit.CM);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() {
        assertThrows(IllegalArgumentException.class, () ->  new Measurement(1, null));
    }

    @Test
    void shouldMeasurementInMEqualToCM() {
        Measurement m1 = new Measurement(1, Unit.M);
        Measurement m2 = new Measurement(100, Unit.CM);
        assertTrue(m1.equals(m2));
    }
    @Test
    void shouldMeasurementInCMEqualToKM() {
        Measurement m1 = new Measurement(100, Unit.CM);
        Measurement m2 = new Measurement(0.0001F, Unit.KM);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldAddTwoMeasurementsInMeters() {
        Measurement m1 = new Measurement(1, Unit.M);
        Measurement m2 = new Measurement(100, Unit.CM);
        Measurement m3 = m1.add(m2);
        Measurement expectedMeasurement = new Measurement(2, Unit.M);
        assertTrue(m3.equals(expectedMeasurement));
    }

    @Test
    void shouldAddTwoMeasurementsInCentimeters() {
        Measurement m1 = new Measurement(0, Unit.CM);
        Measurement m2 = new Measurement(1, Unit.M);
        Measurement m3 = m1.add(m2);
        Measurement expectedMeasurement = new Measurement(100, Unit.CM);
        assertTrue(m3.equals(expectedMeasurement));
    }

}
