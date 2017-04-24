package com.sandy.core.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by gondals on 31/07/16.
 */
public class Employee extends Emp implements Serializable {

    private int id;
    private String name;
    transient private Address address;

    public Employee() {
    }

    public Employee(final int id, final String name, final Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(address.getPin());
        objectOutputStream.writeBytes(address.getState());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int pin = objectInputStream.readInt();
        String state = objectInputStream.readLine();
        address = new Address(pin, state);
    }
}
