package com.sandy.programs.pro1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gondals on 18/09/16.
 */
public class CreditHolderTest {

    @Test
    public void shouldInitializeCreditHolder() throws Exception {
        CreditHolder unit = CreditHolder.getInstance(gerRomanMappingHolder());
        unit.init(new String[] {"glob", "glob"}, "Silver", 34);
    }

    @Test
    public void shouldConvertAndReturnStringValues1() throws Exception {
        CreditHolder unit = CreditHolder.getInstance(gerRomanMappingHolder());
        unit.init(new String[] {"glob", "glob"}, "Silver", 34);

        double val = unit.convert(new String[] {"glob", "glob"}, "Silver");
        Assert.assertEquals(34.0, val, 0.01);
    }

    @Test
    public void shouldConvertAndReturnStringValues2() throws Exception {
        CreditHolder unit = CreditHolder.getInstance(gerRomanMappingHolder());
        unit.init(new String[] {"glob", "glob"}, "Silver", 34);
        unit.init(new String[] {"glob", "prok"}, "Gold", 57800);
        unit.init(new String[] {"pish", "pish"}, "Iron", 3910);

        double val = unit.convert(new String[] {"glob", "prok"}, "Silver");
        Assert.assertEquals(68.0, val, 0.01);

        val = unit.convert(new String[] {"glob", "prok"}, "Gold");
        Assert.assertEquals(57800.0, val, 0.01);

        val = unit.convert(new String[] {"glob", "prok"}, "Iron");
        Assert.assertEquals(782.0, val, 0.01);
    }

    @Test
    public void shouldConvertAndReturnStringValues3() throws Exception {
        CreditHolder unit = CreditHolder.getInstance(gerRomanMappingHolder());
        unit.init(new String[] {"glob", "glob"}, "Silver", 34);
        unit.init(new String[] {"glob", "prok"}, "Gold", 57800);
        unit.init(new String[] {"pish", "pish"}, "Iron", 3910);

        double val = unit.convert(new String[] {"pish", "tegh", "glob", "glob"}, "");
        Assert.assertEquals(42, val, 0.01);


    }

    private RomanMappingHolder gerRomanMappingHolder() {
        RomanMappingHolder romanMappingHolder = RomanMappingHolder.getInstance();
        romanMappingHolder.init("prok", "V");
        romanMappingHolder.init("glob", "I");
        romanMappingHolder.init("pish", "X");
        romanMappingHolder.init("tegh", "L");
        return romanMappingHolder;
    }
}
