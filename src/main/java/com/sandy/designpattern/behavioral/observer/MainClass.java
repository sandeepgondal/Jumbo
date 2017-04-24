package com.sandy.designpattern.behavioral.observer;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Welcome to Observer");

        WeatherDepartment weatherDepartment = new WeatherDepartment();
        weatherDepartment.addListener(new AirportListener());
        weatherDepartment.addListener(new AgricultureListener());
        weatherDepartment.addListener(new TrafficListener());

        weatherDepartment.someEventhappened();
    }

}
