package com.sandy.designpattern.behavioral.observer;

/**
 * Created by gondals on 24/08/16.
 */
public class AirportListener implements Listener {

    @Override
    public void update() {
        System.out.println("AirportListener called");
    }

}
