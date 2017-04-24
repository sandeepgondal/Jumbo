package com.sandy.spring.di.withConfigFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by gondals on 31/08/16.
 */

@Configuration
public class ConfigurationFile {

    @Bean (name = "configBean")
    @Scope(value = "prototype")
    public ConfigBean getConfigBean() {
        System.out.println("getConfigBean called");
        return new ConfigBean(getConfigBean1(), getConfigBean2());
    }

    @Bean (name = "configBean1")
    public ConfigBean1 getConfigBean1() {
        System.out.println("getConfigBean1 called");
        return new ConfigBean1();
    }

    @Bean (name = "configBean2")
    public ConfigBean2 getConfigBean2() {
        System.out.println("getConfigBean2 called");
        return new ConfigBean2();
    }
}
