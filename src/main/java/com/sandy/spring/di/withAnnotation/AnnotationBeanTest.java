package com.sandy.spring.di.withAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gondals on 31/08/16.
 */
public class AnnotationBeanTest {

    public static void main(String[] args) {
        System.out.println("Hello Annotation");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myAppContext.xml");


        MyAnnotBean myAnnotBean = (MyAnnotBean) applicationContext.getBean("myAnnotBean");
        myAnnotBean.printName();
    }

}
