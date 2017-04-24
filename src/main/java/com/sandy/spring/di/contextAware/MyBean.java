package com.sandy.spring.di.contextAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by gondals on 31/08/16.
 */

@Component
public class MyBean implements BeanNameAware, ApplicationContextAware {

    @Override
    public void setBeanName(final String beanName) {
        System.out.println("Bean name is: " + beanName);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        System.out.println("Got application context");
        System.out.println("Loading another bean");
        AnotherBean anotherBean = (AnotherBean) applicationContext.getBean("anotherBean");
        anotherBean.printSomething();
    }
}
