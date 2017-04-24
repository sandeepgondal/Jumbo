package com.sandy.spring.di.contextAware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gondals on 31/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Spring");

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");

        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("myAppContext.xml"));
//        beanFactory.ad

        applicationContext.registerShutdownHook();
    }

}
