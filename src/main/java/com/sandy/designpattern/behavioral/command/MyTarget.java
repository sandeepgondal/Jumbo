package com.sandy.designpattern.behavioral.command;

/**
 * Created by gondals on 24/08/16.
 */
public class MyTarget implements Target {
    private String name;
    private double salary;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void printDetails() {
        System.out.println("Name is " + name + " and salary is " + salary);
    }
}
