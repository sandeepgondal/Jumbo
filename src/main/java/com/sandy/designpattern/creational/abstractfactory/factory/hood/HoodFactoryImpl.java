package com.sandy.designpattern.creational.abstractfactory.factory.hood;

import com.sandy.designpattern.creational.abstractfactory.factory.Stamper;

/**
 * Created by gondals on 24/08/16.
 */
public class HoodFactoryImpl implements HoodFactory {

    @Override
    public Stamper ecosport() {
        return () -> "Eco Sport Hood Stamper";
    }

    @Override
    public Stamper ciaz() {
        return () -> "Ciaz Hood Stamper";
    }

    @Override
    public Stamper jazz() {
        return () -> "Jazz Hood Stamper";
    }

}
