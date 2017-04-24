package com.sandy.designpattern.creational.abstractfactory.factory.door;

import com.sandy.designpattern.creational.abstractfactory.factory.Stamper;

/**
 * Created by gondals on 24/08/16.
 */
public interface DoorFactory {

    Stamper baleno();

    Stamper brezza();

    Stamper creta();

}
