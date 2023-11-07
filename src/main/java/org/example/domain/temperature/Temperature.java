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
        float value1 = value * unit.getMultiplicativeFactor() + unit.getAdditiveFactor();
        float value2 = that.value * that.unit.getMultiplicativeFactor() + that.unit.getAdditiveFactor();
        System.out.println("**********");
        System.out.println(value1);
        System.out.println(value2);

        return Float.compare(value * unit.getMultiplicativeFactor() + unit.getAdditiveFactor(), that.value * that.unit.getMultiplicativeFactor() + that.unit.getAdditiveFactor()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value * unit.getMultiplicativeFactor() + unit.getAdditiveFactor());
    }
}
