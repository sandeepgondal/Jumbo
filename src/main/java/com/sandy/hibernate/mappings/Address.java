package com.sandy.hibernate.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by gondals on 31/08/16.
 */

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "pin")
    private long pin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(final long pin) {
        this.pin = pin;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
}
