package com.sandy.spring.di.withXmlConfigFile;

/**
 * Created by gondals on 31/08/16.
 */
public class MyXMLBean {

    private MyXMLBean1 myXMLBean1;
    private MyXMLBean2 myXMLBean2;

    public MyXMLBean1 getMyXMLBean1() {
        return myXMLBean1;
    }

    public void setMyXMLBean1(final MyXMLBean1 myXMLBean1) {
        this.myXMLBean1 = myXMLBean1;
    }

    public MyXMLBean2 getMyXMLBean2() {
        return myXMLBean2;
    }

    public void setMyXMLBean2(final MyXMLBean2 myXMLBean2) {
        this.myXMLBean2 = myXMLBean2;
    }

    public void printNames() {
        System.out.println(myXMLBean1.getName() + " " + myXMLBean2.getName());
    }

}
