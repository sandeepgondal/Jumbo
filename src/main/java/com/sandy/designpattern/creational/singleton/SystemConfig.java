package com.sandy.designpattern.creational.singleton;

/**
 * Created by gondals on 24/08/16.
 */
public class SystemConfig {

    public SystemConfig() {
        System.out.println("Creating instance of singleton class");
    }

    public static SystemConfig getInstance() {
        System.out.println("Returning instance of singleton class");
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static SystemConfig INSTANCE = new SystemConfig();
    }

}
