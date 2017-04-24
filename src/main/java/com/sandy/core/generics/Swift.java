package com.sandy.core.generics;

/**
 * Created by gondals on 31/07/16.
 */
public class Swift extends Vehicle {

    private int cc;
    private int bhp;

    public Swift() {
    }

    public Swift(final int id, final String type, final String color, final int cc, final int bhp) {
        super(id, type, color);
        this.cc = cc;
        this.bhp = bhp;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(final int cc) {
        this.cc = cc;
    }

    public int getBhp() {
        return bhp;
    }

    public void setBhp(final int bhp) {
        this.bhp = bhp;
    }
}
