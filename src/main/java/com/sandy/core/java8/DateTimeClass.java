package com.sandy.core.java8;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Created by gondals on 09/08/16.
 */
public class DateTimeClass {

    public static void main(String[] args) {
        System.out.println("Hello Date and Time");

        System.out.println(LocalTime.now(Clock.systemUTC()));
        System.out.println(LocalTime.now(ZoneId.of("Asia/Kolkata")));


    }

}
