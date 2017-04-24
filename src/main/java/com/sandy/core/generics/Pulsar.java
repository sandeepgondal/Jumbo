package com.sandy.core.generics;

/**
 * Created by gondals on 31/07/16.
 */
public class Pulsar extends Vehicle {

    private boolean electricStart;

    public Pulsar() {
    }

    public Pulsar(final int id, final String type, final String color, final boolean electricStart) {
        super(id, type, color);
        this.electricStart = electricStart;
    }

    public boolean isElectricStart() {
        return electricStart;
    }

    public void setElectricStart(final boolean electricStart) {
        this.electricStart = electricStart;
    }
}
