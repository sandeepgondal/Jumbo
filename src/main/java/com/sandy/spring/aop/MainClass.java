package com.sandy.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gondals on 31/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello AOP");

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");
        MyAOPBean myBean = (MyAOPBean) classPathXmlApplicationContext.getBean("myAOPBean");
        myBean.myMethod();
    }

}
