package com.sandy.designpattern.creational.abstractfactory;

import com.sandy.designpattern.creational.abstractfactory.factory.bumper.BumperFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.door.DoorFactory;
import com.sandy.designpattern.creational.abstractfactory.factory.hood.HoodFactory;

/**
 * Created by gondals on 24/08/16.
 */
public interface StampFactory {

    BumperFactory getBumperFactory();

    DoorFactory getDoorFactory();

    HoodFactory getHoodFactory();

}
