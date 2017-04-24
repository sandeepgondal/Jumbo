package com.sandy.core.java8;

/**
 * Created by gondals on 02/08/16.
 */
public class Address {

    private int pin;
    private String state;

    public Address(final int pin, final String state) {
        this.pin = pin;
        this.state = state;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(final int pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pin=" + pin +
                ", state='" + state + '\'' +
                '}';
    }
}
