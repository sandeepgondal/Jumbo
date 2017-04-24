package com.sandy.mockito.case1;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by gondals on 27/08/16.
 */

public interface MarginFetcher {

    BigDecimal fetchMargin(long customerNumber, long packageId);

}
