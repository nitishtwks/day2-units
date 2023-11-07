package org.example.domain.length;

public enum Unit {
    CM(1),
    M(100),
    KM(100000);

    private final float normalizingFactor;

    Unit(float factor) {
        this.normalizingFactor = factor;
    }

    public float getNormalizingFactor(){
        return normalizingFactor;
    }
}