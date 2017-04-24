package com.sandy.core.generics;

/**
 * Created by gondals on 31/07/16.
 */
public class Vehicle {

    private int id;
    private String type;
    private String color;

    public Vehicle() {
    }

    public Vehicle(final int id, final String type, final String color) {
        this.id = id;
        this.type = type;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}
