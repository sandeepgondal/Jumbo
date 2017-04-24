package com.sandy.designpattern.structural.adapter;

import java.math.BigDecimal;

/**
 * Created by gondals on 24/08/16.
 */
public class MyAdapter {

    public static MyPojo adapt(MyEntity myEntity) {
        MyPojo myPojo = new MyPojo();
        myPojo.setUniqueId(myEntity.getId());
        myPojo.setUserName(myEntity.getName());
        myPojo.setTotalPay(new BigDecimal(myEntity.getTotal()));
        return myPojo;
    }

}
