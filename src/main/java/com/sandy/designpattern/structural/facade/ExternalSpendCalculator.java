package com.sandy.designpattern.structural.facade;

import java.math.BigDecimal;

/**
 * Created by gondals on 24/08/16.
 */
public class ExternalSpendCalculator implements SpendCalculator {

    @Override
    public BigDecimal compute() {
        return new BigDecimal(111.11);
    }

}
