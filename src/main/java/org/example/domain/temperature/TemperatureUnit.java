package org.example.domain.temperature;

public enum TemperatureUnit {
    C(1, 0),
    F(9/5, -32),
    K(1, -273.15f);

    private final float multiplicativeFactor;

    private final float additiveFactor;

    TemperatureUnit(float multiplicativeFactor, float additiveFactor) {
        this.multiplicativeFactor = multiplicativeFactor;
        this.additiveFactor = additiveFactor;
    }

    public float getMultiplicativeFactor() {
        return multiplicativeFactor;
    }

    public float getAdditiveFactor() {
        return additiveFactor;
    }
}