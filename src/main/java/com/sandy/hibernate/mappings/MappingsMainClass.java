package com.sandy.hibernate.mappings;

import com.sandy.hibernate.SessionFactoryCreator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.Random;

/**
 * Created by gondals on 31/08/16.
 */
public class MappingsMainClass {

    public static void main(String[] args) {
        System.out.println("Hello Hibernate");
        SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();

        // Employee and Vehicle has one to one mapping
        Employee employee = createEmployee();
        Vehicle vehicle = createVehicle();
        employee.setVehicle(vehicle);
        saveEntity(employee, sessionFactory);

        // Employees and Projects have many to many mappings
        Employee employee1 = createEmployee();
        Employee employee2 = createEmployee();
        Employee employee3 = createEmployee();
        Project project1 = createProject();
        Project project2 = createProject();
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employee2.getProjects().add(project2);
        employee3.getProjects().add(project1);
        saveEntity(employee1, sessionFactory);
        saveEntity(employee2, sessionFactory);
        saveEntity(employee3, sessionFactory);

        // One Employee has Many Addresses
        Address address1 = createAddress();
        Address address2 = createAddress();
        Employee employee4 = createEmployee();
        employee4.getAddresses().add(address1);
        employee4.getAddresses().add(address2);
        address1.setEmployee(employee4);
        address2.setEmployee(employee4);
        saveEntity(employee4, sessionFactory);

        sessionFactory.close();
    }

    private static Vehicle createVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Swift" + new Random().nextInt());
        vehicle.setColor("White" + new Random().nextInt());
        return vehicle;
    }

    private static void saveEntity(final Object entity, final SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    private static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setName("Sandeep" + new Random().nextInt());
        return employee;
    }

    private static Project createProject() {
        Project project = new Project();
        project.setName("DAP" + new Random().nextInt());
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        return project;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setCity("Pune" + new Random().nextInt());
        address.setPin(new Random().nextInt());
        return address;
    }

}
