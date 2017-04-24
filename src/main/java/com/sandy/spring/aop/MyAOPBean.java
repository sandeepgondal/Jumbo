package com.sandy.spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created by gondals on 31/08/16.
 */

@Component
public class MyAOPBean {

    public void myMethod() {
        System.out.println("myMethod called in MyAOPBeanWithAnnotation");
    }

}
