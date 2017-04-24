package com.sandy.designpattern.creational.abstractfactory;

import com.sandy.designpattern.creational.abstractfactory.factory.bumper.BumperFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.bumper.BumperFactoryImpl;
import com.sandy.designpattern.creational.abstractfactory.factory.door.DoorFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.door.DoorFactoryImpl;
import com.sandy.designpattern.creational.abstractfactory.factory.hood.HoodFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.hood.HoodFactoryImpl;

/**
 * Created by gondals on 24/08/16.
 */
public class StampFactoryImpl implements StampFactory {


    @Override
    public BumperFactory getBumperFactory() {
        return new BumperFactoryImpl();
    }

    @Override
    public DoorFactory getDoorFactory() {
        return new DoorFactoryImpl();
    }

    @Override
    public HoodFactory getHoodFactory() {
        return new HoodFactoryImpl();
    }
}
