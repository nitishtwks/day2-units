package org.example.domain;

public class Measurement {

    private final float value;

    private final Unit unit;

    private float normalizedValue;
    
    public Measurement(float value, Unit unit) throws IllegalArgumentException {
        if(unit==null){
            throw new IllegalArgumentException("Please provide a valid unit");
        }
        this.value = value;
        this.unit = unit;
        this.covertIntoDefault(value,unit);
    }

    private void covertIntoDefault(float value, Unit unit) {
        switch (unit) {
            case KM:
                normalizedValue = 1000*value;
                break;
            case M:
                normalizedValue = 100*value;
                break;
            default:
                normalizedValue = value;
                break;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(value);
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        result = prime * result + Float.floatToIntBits(normalizedValue);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Measurement other = (Measurement) obj;
        if (Float.floatToIntBits(normalizedValue) != Float.floatToIntBits(other.normalizedValue))
            return false;
        return true;
    }
    
}
