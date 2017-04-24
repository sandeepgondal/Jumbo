package com.sandy.spring.di.withXmlConfigFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gondals on 31/08/16.
 */
public class XMLBeanTest {

    public static void main(String[] args) {
        System.out.println("Hello Spring");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");
        MyXMLBean myXMLBean = (MyXMLBean) applicationContext.getBean("myXMLBean");
        myXMLBean.printNames();
    }

}
