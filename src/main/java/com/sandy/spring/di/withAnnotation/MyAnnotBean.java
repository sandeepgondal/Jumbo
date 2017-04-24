package com.sandy.spring.di.withAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gondals on 31/08/16.
 */

@Service
public class MyAnnotBean {

    @Autowired private MyAnnotBean1 myAnnotBean1;
    @Autowired private MyAnnotBean2 myAnnotBean2;

    public void printName() {
        System.out.println(myAnnotBean1.getName() + " " + myAnnotBean2.getName());
    }

}
