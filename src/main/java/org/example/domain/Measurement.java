package org.example.domain;

import java.util.Objects;

public class Measurement {

    private final float value;

    private final Unit unit;
    
    public Measurement(float value, Unit unit) throws IllegalArgumentException {
        if(unit==null){
            throw new IllegalArgumentException("Please provide a valid unit");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Float.compare(value * unit.getNormalizingFactor(), that.value * that.unit.getNormalizingFactor()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value * unit.getNormalizingFactor());
    }
}
