package com.sandy.core.java8;

import java.util.List;

/**
 * Created by gondals on 02/08/16.
 */
public class Employee {

    private int id;
    private String name;
    private List<Address> addresses;

    public Employee(final int id, final String name, final List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }
}
