package org.example.domain;

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

    public boolean isEqualTo(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Measurement other = (Measurement) obj;
        if (Float.floatToIntBits(value * unit.getNormalizingFactor()) != Float.floatToIntBits(other.value * other.unit.getNormalizingFactor()))
            return false;
        return true;
    }
    
}
