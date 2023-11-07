package org.example.test.temperature;

import org.example.domain.temperature.Temperature;
import org.example.domain.temperature.TemperatureUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void shouldEqualToMeasurement() {
        Temperature m1 = new Temperature(1, TemperatureUnit.C);
        Temperature m2 = new Temperature(33.8f, TemperatureUnit.F);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldNotEqualToMeasurement() {
        Temperature m1 = new Temperature(1, TemperatureUnit.C);
        Temperature m2 = new Temperature(33.8f, TemperatureUnit.F);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() {
        assertThrows(IllegalArgumentException.class, () ->  new Temperature(1, null));
    }

    @Test
    void shouldMeasurementInMEqualToCM() {
        Temperature m1 = new Temperature(1, TemperatureUnit.C);
        Temperature m2 = new Temperature(100, TemperatureUnit.C);
        assertTrue(m1.equals(m2));
    }
    @Test
    void shouldMeasurementInCMEqualToKM() {
        Temperature m1 = new Temperature(100, TemperatureUnit.C);
        Temperature m2 = new Temperature(0.0001F, TemperatureUnit.C);
        assertFalse(m1.equals(m2));
    }

}
