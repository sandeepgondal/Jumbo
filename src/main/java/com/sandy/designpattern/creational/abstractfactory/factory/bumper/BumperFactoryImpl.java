package com.sandy.designpattern.creational.abstractfactory.factory.bumper;

import com.sandy.designpattern.creational.abstractfactory.factory.Stamper;

/**
 * Created by gondals on 24/08/16.
 */
public class BumperFactoryImpl implements BumperFactory {


    @Override
    public Stamper swift() {
        return () -> "Swift Bumper Stamper";
    }

    @Override
    public Stamper polo() {
        return () -> "Polo Bumper Stamper";
    }

    @Override
    public Stamper city() {
        return () -> "City Bumper Stamper";
    }

}
