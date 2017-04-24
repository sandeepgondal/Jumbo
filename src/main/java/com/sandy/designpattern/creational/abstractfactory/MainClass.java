package com.sandy.designpattern.creational.abstractfactory;

import com.sandy.designpattern.creational.abstractfactory.factory.bumper.BumperFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.door.DoorFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.hood.HoodFactory;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Abstract Factory");

        StampFactory stampFactory = new StampFactoryImpl();

        System.out.println("*** Bumpers ***");
        BumperFactory bumperFactory = stampFactory.getBumperFactory();
        System.out.println(bumperFactory.swift().stamp());
        System.out.println(bumperFactory.polo().stamp());
        System.out.println(bumperFactory.city().stamp());

        System.out.println("\n*** Doors ***");
        DoorFactory doorFactory = stampFactory.getDoorFactory();
        System.out.println(doorFactory.baleno().stamp());
        System.out.println(doorFactory.brezza().stamp());
        System.out.println(doorFactory.creta().stamp());

        System.out.println("\n*** Hoods ***");
        HoodFactory hoodFactory = stampFactory.getHoodFactory();
        System.out.println(hoodFactory.ciaz().stamp());
        System.out.println(hoodFactory.ecosport().stamp());
        System.out.println(hoodFactory.jazz().stamp());
    }

}
