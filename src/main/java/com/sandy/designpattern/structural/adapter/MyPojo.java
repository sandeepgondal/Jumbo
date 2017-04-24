package com.sandy.designpattern.structural.adapter;

import java.math.BigDecimal;

/**
 * Created by gondals on 24/08/16.
 */
public class MyPojo {

    private Integer uniqueId;
    private String userName;
    private BigDecimal totalPay;

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(final Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(final BigDecimal totalPay) {
        this.totalPay = totalPay;
    }
}
