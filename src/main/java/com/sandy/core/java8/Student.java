package com.sandy.core.java8;

/**
 * Created by gondals on 02/08/16.
 */
public class Student {

    private int id;
    private String name;

    public Student(final int id, final String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        Student s = (Student) obj;
        return this.getName().equals(s.getName());
    }
}
