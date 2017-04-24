package com.sandy.programs.shopperstop;

import com.sandy.programs.shopperstop.PremiumInvoiceCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gondals on 18/09/16.
 */
public class PremiumInvoiceCalculatorTest {

    private PremiumInvoiceCalculator unit;

    @Before
    public void setUp() throws Exception {
        unit = PremiumInvoiceCalculator.getInstance();
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithInvalidAmount() throws Exception {
        unit.generate(-10);
    }

    @Test
    public void shouldReturnInvoiceForFirstSlab() throws Exception {
        assertEquals(3600, unit.generate(4000), 0.01);
    }

    @Test
    public void shouldReturnDiscountForSecondSlab() throws Exception {
        assertEquals(7000, unit.generate(8000), 0.01);
    }

    @Test
    public void shouldReturnDiscountForThirdSlab() throws Exception {
        assertEquals(10200, unit.generate(12000), 0.01);
        assertEquals(7800, unit.generate(9000), 0.01);
    }

    @Test
    public void shouldReturnDiscountForFourthSlab() throws Exception {
        assertEquals(15800, unit.generate(20000), 0.01);

    }

}
