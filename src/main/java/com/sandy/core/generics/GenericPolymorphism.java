package com.sandy.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 31/07/16.
 *
 * Wild Characters
 */
public class GenericPolymorphism {

    public static void main(String[] args) {
        System.out.println("Hello Generics");
        new GenericPolymorphism().executeWildExtends();
        new GenericPolymorphism().executeWildSuper();
    }

    private void executeWildExtends() {
        List<Swift> swifts = new ArrayList<>();
        Swift swift1 = new Swift(1, "New", "White", 1200, 65);
        Swift swift2 = new Swift(2, "Old", "Black", 1200, 65);
        swifts.add(swift1);
        swifts.add(swift2);
        printVehicles(swifts);

        //

        List<Pulsar> pulsars = new ArrayList<>();
        Pulsar pulsar1 = new Pulsar(1, "180 Black", "Black", true);
        Pulsar pulsar2 = new Pulsar(2, "150 Old", "Blue", false);
        pulsars.add(pulsar1);
        pulsars.add(pulsar2);
        printVehicles(pulsars);

    }

    private void printVehicles(final List<? extends Vehicle> vehicles) {
        vehicles.stream()
                .forEach(v -> System.out.println(v.getColor() + " " + v.getType()));
    }

    private void executeWildSuper() {
        List<Vehicle> vehicles = new ArrayList<>();
        addAndPrintSwifts(vehicles);
    }

    private void addAndPrintSwifts(final List<? super Swift> swifts) {
        swifts.add(new Swift(11, "New1", "White1", 1200, 65));
        swifts.add(new Swift(12, "New2", "White2", 1200, 65));

        swifts.stream()
                .forEach(s -> {
                    Swift swift = (Swift) s;
                    System.out.println(swift.getColor() + " " + swift.getId() + " " + swift.getBhp());
                });
    }
}
