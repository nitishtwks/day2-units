package org.example.domain.temperature;

import java.util.Objects;

public class Temperature {

    private final float value;

    private final TemperatureUnit unit;

    public Temperature(float value, TemperatureUnit unit) throws IllegalArgumentException {
        if(unit ==null){
            throw new IllegalArgumentException("Please provide a valid unit");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        float value1 = (float) Math.ceil(unit.getMultiplicativeFactor() * (value + unit.getAdditiveFactor()));
        float value2 = (float) Math.ceil(that.unit.getMultiplicativeFactor() * (that.value + that.unit.getAdditiveFactor()));
        return Float.compare(value1, value2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value * unit.getMultiplicativeFactor() + unit.getAdditiveFactor());
    }
}
