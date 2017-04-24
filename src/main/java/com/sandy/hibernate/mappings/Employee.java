package com.sandy.hibernate.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by gondals on 31/08/16.
 */

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Project> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Address> addresses = new ArrayList<>();

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(final Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final Collection<Address> addresses) {
        this.addresses = addresses;
    }
}
