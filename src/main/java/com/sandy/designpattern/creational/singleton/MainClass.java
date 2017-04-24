package com.sandy.designpattern.creational.singleton;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Singleton");

        SystemConfig systemConfig1 = SystemConfig.getInstance();
        SystemConfig systemConfig2 = SystemConfig.getInstance();
        SystemConfig systemConfig3 = SystemConfig.getInstance();

    }

}
