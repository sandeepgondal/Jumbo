package com.sandy.mockito.case1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by gondals on 27/08/16.
 */

@Component
public class InvoiceCalculator {

    @Autowired MarginFetcher marginFetcher;
    @Autowired SpendFetcher spendFetcher;

    public BigDecimal computeInvoice(final long customerNumber, final long packageId) {

        final BigDecimal margin = marginFetcher.fetchMargin(customerNumber, packageId);
        final BigDecimal internalSpend = spendFetcher.getInternalSpend(customerNumber, packageId);
        final BigDecimal externalSpend = spendFetcher.getExternalSpend(customerNumber, packageId);
        final BigDecimal errorSpend = spendFetcher.getErrorSpend(customerNumber, packageId);

        BigDecimal totalSpend = internalSpend.add(externalSpend).subtract(errorSpend);
        if (BigDecimal.ZERO.compareTo(totalSpend) > 0)
            totalSpend = BigDecimal.ZERO;

        return totalSpend.divide(BigDecimal.ONE.subtract(margin), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal sendInvoice(final long customerNumber, final long packageId) {
        if (customerNumber == 100)
            throw new IllegalArgumentException("Invalid Customer");

        return computeInvoice(customerNumber, packageId);

    }
}
