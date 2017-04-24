package com.sandy.spring.di.withConfigFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gondals on 31/08/16.
 */
public class ConfigBeanTest {

    public static void main(String[] args) {
        System.out.println("Hello Config Bean");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationFile.class);

        ConfigBean configBeanObj1 = (ConfigBean) applicationContext.getBean("configBean");
        configBeanObj1.printNames();

        ConfigBean configBeanObj2 = (ConfigBean) applicationContext.getBean("configBean");
        configBeanObj2.printNames();
    }

}
