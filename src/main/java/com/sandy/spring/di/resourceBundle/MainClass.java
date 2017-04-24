package com.sandy.spring.di.resourceBundle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by gondals on 31/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Resource Properties");

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");
        String message = applicationContext.getMessage("customer.greet", new Object[] {"Sandeep"}, Locale.US);
        System.out.println("\n\n\nMessage received: " + message);
    }

}
