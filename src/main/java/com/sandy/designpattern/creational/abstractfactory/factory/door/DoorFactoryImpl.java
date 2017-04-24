package com.sandy.designpattern.creational.abstractfactory.factory.door;

import com.sandy.designpattern.creational.abstractfactory.factory.Stamper;

/**
 * Created by gondals on 24/08/16.
 */
public class DoorFactoryImpl implements DoorFactory {

    @Override
    public Stamper baleno() {
        return () -> "Baleno Hood Stamper";
    }

    @Override
    public Stamper brezza() {
        return () -> "Brezza Hood Stamper";
    }

    @Override
    public Stamper creta() {
        return () -> "Creata Hood Stamper";
    }

}
