package com.sandy.spring.di.contextAware;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by gondals on 31/08/16.
 */

@Component
public class AnotherBean {

    public void printSomething() {
        System.out.println("I am another bean");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Inside initMethod");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Inside destroyMethod");
    }

}
