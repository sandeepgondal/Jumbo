package com.sandy.spring.di.withConfigFile;

/**
 * Created by gondals on 31/08/16.
 */
public class ConfigBean {

    private ConfigBean1 configBean1;
    private ConfigBean2 configBean2;

    public ConfigBean(final ConfigBean1 configBean1, final ConfigBean2 configBean2) {
        this.configBean1 = configBean1;
        this.configBean2 = configBean2;
    }

    public void printNames() {
        System.out.println(configBean1.getName() + " " + configBean2.getName());
    }

}
