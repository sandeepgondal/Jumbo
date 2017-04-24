package com.sandy.designpattern.creational.abstractfactory.factory.bumper;

import com.sandy.designpattern.creational.abstractfactory.factory.Stamper;

/**
 * Created by gondals on 24/08/16.
 */
public interface BumperFactory {

    Stamper swift();

    Stamper polo();

    Stamper city();

}
