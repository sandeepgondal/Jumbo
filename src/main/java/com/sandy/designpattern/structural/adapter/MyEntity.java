package com.sandy.designpattern.structural.adapter;

/**
 * Created by gondals on 24/08/16.
 */
public class MyEntity {

    private int id;
    private String name;
    private double total;

    public MyEntity(final int id, final String name, final double total) {
        this.id = id;
        this.name = name;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(final double total) {
        this.total = total;
    }
}
