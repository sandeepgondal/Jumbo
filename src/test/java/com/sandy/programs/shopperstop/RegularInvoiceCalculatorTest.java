package com.sandy.programs.shopperstop;

import com.sandy.programs.shopperstop.RegularInvoiceCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gondals on 18/09/16.
 */
public class RegularInvoiceCalculatorTest {

    private RegularInvoiceCalculator unit;

    @Before
    public void setUp() throws Exception {
        unit = RegularInvoiceCalculator.getInstance();
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithInvalidAmount() throws Exception {
        unit.generate(-10);
    }

    @Test
    public void shouldReturnInvoiceForFirstSlab() throws Exception {
        assertEquals(5000, unit.generate(5000), 0.01);
    }

    @Test
    public void shouldReturnDiscountForSecondSlab() throws Exception {
        assertEquals(9500, unit.generate(10000), 0.01);
    }

    @Test
    public void shouldReturnDiscountForThirdSlab() throws Exception {
        assertEquals(13500, unit.generate(15000), 0.01);
        assertEquals(11100, unit.generate(12000), 0.01);
    }

}
