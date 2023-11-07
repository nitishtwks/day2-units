package org.example.domain;

public enum Unit{
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