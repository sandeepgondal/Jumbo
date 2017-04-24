package com.sandy.core.annotation;

/**
 * Created by gondals on 29/08/16.
 */
public class MyClass {

    @MyColumnAnnotation(value = "name field", type = "External")
    private String name;

    @MyColumnAnnotation(value = "address field")
    private String address;

    private int pin;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(final int pin) {
        this.pin = pin;
    }
}
