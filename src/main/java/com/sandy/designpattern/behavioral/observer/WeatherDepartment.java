package com.sandy.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 24/08/16.
 */
public class WeatherDepartment {

    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void someEventhappened() {
        listeners.forEach( l -> l.update());
    }

}
