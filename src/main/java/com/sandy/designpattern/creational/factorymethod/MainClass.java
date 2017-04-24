package com.sandy.designpattern.creational.factorymethod;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Factory Method");

        ShapeFactory shapeFactory = new ShapeFactoryImpl();
        shapeFactory.getCircle().draw();
        shapeFactory.getSquare().draw();
        shapeFactory.getTriangle().draw();
    }

}
