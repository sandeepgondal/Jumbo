package com.sandy.designpattern.creational.factorymethod;

/**
 * Created by gondals on 24/08/16.
 */
public class ShapeFactoryImpl implements ShapeFactory {


    @Override
    public Shape getSquare() {
        return new SquareShape();
    }

    @Override
    public Shape getCircle() {
        return new CircleShape();
    }

    @Override
    public Shape getTriangle() {
        return new TriangleShape();
    }
}
