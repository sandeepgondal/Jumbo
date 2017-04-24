package com.sandy.spring.di.configProperties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by gondals on 31/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello properties");

        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");
        MyPropBean myPropBean = (MyPropBean) xmlApplicationContext.getBean("myPropBean");
        System.out.println("\n\n\nJDBC URL: " + myPropBean.getJdbcUrl());
        System.out.println("JDBC Username: " + myPropBean.getJdbcUsername());
        System.out.println("JDBC Password: " + myPropBean.getJdbcPassword());
    }

}
