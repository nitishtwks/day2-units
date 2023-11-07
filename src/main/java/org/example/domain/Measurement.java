package org.example.domain;

public class Measurement {

    private final int value;

    private final String unit;

    public Measurement(int value, String unit) throws IllegalArgumentException {
        if(unit==null){
            throw new IllegalArgumentException("Please provide a valid unit");
        }
        this.value = value;
        this.unit = unit;
    }

    public boolean isEqualTo(Measurement measurement){
        if(measurement.value==this.value && measurement.unit.equals(this.unit)){
            return true;
        }
        return false;
    }
}
