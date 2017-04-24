package com.sandy.designpattern.structural.adapter;

import java.math.BigDecimal;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Adapter");

        MyEntity myEntity = new MyEntity(12, "Sandeep", 123.45);
        MyPojo myPojo = MyAdapter.adapt(myEntity);
        System.out.println("Unique Id: " + myPojo.getUniqueId() + ", User Name: " + myPojo.getUserName() + ", Total Pay: " + myPojo.getTotalPay());

    }

}
