package com.sandy.core.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by gondals on 02/08/16.
 */
public class MainJava8 {

    private static List<Student> students = new ArrayList<>();

    static
    {
        students.add(new Student(1, "Sandeep"));
        students.add(new Student(5, "Smita"));
        students.add(new Student(3, "Vivaan"));
        students.add(new Student(9, "Sandeep"));
        students.add(new Student(7, "Anushka"));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Java 8");

        testFunctionalInterface();
        testLambdaExpressions();

        printCollection(students);
        filterItems();
        convertToNewItems();
        sortItems();
        collectToList();
        collectToSet();
        collectToMap();
        groupingByToMultiMap();
        joined();
        collectorReducing();
        streamReduce();
        flatMap();
        toArray();
    }

    private static void toArray() {
        System.out.println("Converting to array");
        Student[] students = MainJava8.students.stream().toArray(size -> new Student[size]);
        for (Student student : students)
            System.out.println(student);
    }

    private static void testFunctionalInterface() {
        System.out.println("");
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Hello");
        myFunctionalInterface.sayHello();
        myFunctionalInterface.printGreetingMessage();
    }

    private static void testLambdaExpressions() {
        System.out.println("");
        new Thread(() -> {
            System.out.println("Inside new thread and run method");
        }).start();
    }

    private static void filterItems() {
        System.out.println("");
        System.out.println("Filter items, id > 3");
        students.stream()
                .filter(s -> s.getId() > 3)
                .forEach(System.out::println);
    }

    private static void convertToNewItems() {
        System.out.println("");
        System.out.println("Mapped to new values");
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    private static void sortItems() {
        System.out.println("");
        System.out.println("Sorting");
        students.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);
    }

    private static void collectToList() {
        System.out.println("\n\nCollect to List");
        List<Student> studentList = MainJava8.students.stream()
                .filter(s -> "Sandeep".equals(s.getName()) || "Smita".equals(s.getName()))
                .collect(Collectors.toList());
        printCollection(studentList);
    }

    private static void collectToSet() {
        System.out.println("\n\nCollect to Set");
        Set<Student> studentSet = students.stream()
                .filter(s -> s.getId() < 100)
                .collect(Collectors.toSet());
        printCollection(studentSet);
    }

    private static void collectToMap() {
        System.out.println("\n\nCollect to Map");
        Map<String, Student> map = students.stream()
                .collect(Collectors.toMap(Student::getName, Function.identity(), (s1, s2) -> s2));

        for (String key : map.keySet())
            System.out.println(map.get(key));
    }

    private static void groupingByToMultiMap() {
        System.out.println("\n\nGroup to a multi map");
        Map<String, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getName));
        for (String key : collect.keySet()) {
            System.out.println("Key: " + key);
            collect.get(key).forEach(s -> System.out.println("   " + s));
        }
    }

    private static void joined() {
        String joinedString = students.stream()
                .map(Student::getName)
                .distinct()
                .collect(Collectors.joining("*"));
        System.out.println("\n\nJoining: " + joinedString);
    }

    private static void collectorReducing() {
        Integer idTotal = students.stream()
                .map(Student::getId)
                .collect(Collectors.reducing(0, Integer::sum));
        System.out.println("\n\nCollector Reducing: " + idTotal);
    }

    private static void streamReduce() {
        Student student = students.stream()
                .reduce(students.get(0), (s1, s2) -> s1.getId() > s2.getId() ? s1 : s2);
        System.out.println("\n\nStream Reduce: " + student);
    }

    private static void printCollection(final Collection<Student> students) {
        System.out.println("");
        System.out.println("Following are all the items");
        students.stream()
            .forEach(System.out::println);
    }

    private static void flatMap() {
        System.out.println("\n\n\nFlat Map");
        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(new Address(411058, "Maharashtra"));
        addresses1.add(new Address(412114, "Mumbai"));
        Employee employee1 = new Employee(1, "Sandeep", addresses1);

        List<Address> addresses2 = new ArrayList<>();
        addresses2.add(new Address(411055, "Punjab"));
        addresses2.add(new Address(412122, "Haryana"));
        addresses2.add(new Address(512122, "Delhi"));
        Employee employee2 = new Employee(2, "Smita", addresses2);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        employees.stream()
                .flatMap(e -> e.getAddresses().stream())
                .forEach(System.out::println);
    }
}
