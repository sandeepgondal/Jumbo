package com.sandy.programs.shopperstop;

import com.sandy.programs.shopperstop.SlabHolder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gondals on 18/09/16.
 */
public class SlabHolderTest {

    private SlabHolder unit;

    @Before
    public void setUp() throws Exception {
        unit = new SlabHolder();
    }

    @Test
    public void shouldComputeEffectiveDiscountForOneSLabWithZeroDiscount() throws Exception {
        unit.add(1, 0);
        double discountAmount = unit.getDiscountAmount(1000);
        assertEquals(1000.0, discountAmount, 0.01);
    }

    @Test
    public void shouldReturnEffectiveDiscountForOneSlabWithDiscount() throws Exception {
        unit.add(1, 10);
        double discountAmount = unit.getDiscountAmount(1000);
        assertEquals(900.0, discountAmount, 0.01);
    }

    @Test
    public void shouldReturnEffectiveDiscountForTwoSlabsWithDiscount() throws Exception {
        unit.add(1, 10);
        unit.add(5001, 20);
        double discountAmount = unit.getDiscountAmount(10000);
        assertEquals(8500.0, discountAmount, 0.01);
    }

    @Test
    public void shouldReturnEffectiveDiscountForThreeSlabsWithDiscount() throws Exception {
        unit.add(1, 0);
        unit.add(5001, 10);
        unit.add(10001, 20);
        double discountAmount = unit.getDiscountAmount(15000);
        assertEquals(13500, discountAmount, 0.01);
    }
}
