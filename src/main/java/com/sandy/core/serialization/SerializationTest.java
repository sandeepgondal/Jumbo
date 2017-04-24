package com.sandy.core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by gondals on 31/07/16.
 */
public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Welcome to Serialization");

        Address address = new Address(411058, "Maharashtra");
        Employee employee = new Employee(1, "Sandeep", address);

        System.out.println("\n\nSerializing");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("temp.txt"));
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();


        System.out.println("\n\nDe-serializing");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("temp.txt"));
        Employee employeeSer = (Employee) objectInputStream.readObject();

        System.out.println(employeeSer.getId() + " " + employeeSer.getName());
        Address addressSer = employeeSer.getAddress();
        System.out.println(addressSer.getPin() + " " + addressSer.getState());
        System.out.println("My Id: " + employeeSer.myId);
    }
}
