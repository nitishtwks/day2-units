package org.example.test.temperature;

import org.example.domain.temperature.Temperature;
import org.example.domain.temperature.TemperatureUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void shouldEqualToMeasurementCelsiusToFar() {
        Temperature m1 = new Temperature(1, TemperatureUnit.C);
        Temperature m2 = new Temperature(33.8f, TemperatureUnit.F);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldNotEqualToMeasurementCelsiusToFar() {
        Temperature m1 = new Temperature(0, TemperatureUnit.C);
        Temperature m2 = new Temperature(1, TemperatureUnit.F);
        assertFalse(m1.equals(m2));
    }

    @Test
    void shouldEqualToMeasurementCelsiusToKelvin() {
        Temperature m1 = new Temperature(0, TemperatureUnit.C);
        Temperature m2 = new Temperature(273.15f, TemperatureUnit.K);
        assertTrue(m1.equals(m2));
    }

    @Test
    void shouldThrowExceptionWhenInvalidUnitProvided() {
        assertThrows(IllegalArgumentException.class, () ->  new Temperature(1, null));
    }
}
