package com.sandy.designpattern.structural.facade;

import java.math.BigDecimal;

/**
 * Created by gondals on 24/08/16.
 */
public class SpendFacadeImpl implements SpendFacade {

    @Override
    public BigDecimal getTotalSpend() {
        SpendCalculator internal = new InternalSpendCalculator();
        SpendCalculator external = new ExternalSpendCalculator();
        SpendCalculator error = new ErrorSpendCalculator();

        return internal.compute().add(external.compute()).subtract(error.compute());
    }

}
