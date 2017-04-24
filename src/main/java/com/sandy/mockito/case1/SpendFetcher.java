package com.sandy.mockito.case1;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by gondals on 27/08/16.
 */

public interface SpendFetcher {

    BigDecimal getInternalSpend(long customerNumber, long packageId);

    BigDecimal getExternalSpend(long customerNumber, long packageId);

    BigDecimal getErrorSpend(long customerNumber, long packageId);

}
