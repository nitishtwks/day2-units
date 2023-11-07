package org.example.domain.length;

import java.util.Objects;

public class Length {

    private final float value;

    private final Unit unit;
    
    public Length(float value, Unit unit) throws IllegalArgumentException {
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
        Length that = (Length) o;
        return Float.compare(value * unit.getNormalizingFactor(), that.value * that.unit.getNormalizingFactor()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value * unit.getNormalizingFactor());
    }

    public Length add(Length m2) {
        float normalizedValue = value * unit.getNormalizingFactor() + m2.value * m2.unit.getNormalizingFactor();
        return new Length(normalizedValue/ unit.getNormalizingFactor(), unit);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
