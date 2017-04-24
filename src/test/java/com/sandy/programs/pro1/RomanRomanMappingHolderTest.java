package com.sandy.programs.pro1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gondals on 18/09/16.
 */
public class RomanRomanMappingHolderTest {

    private RomanMappingHolder unit;

    @Before
    public void setUp() throws Exception {
        unit = RomanMappingHolder.getInstance();
    }

    @Test
    public void shouldBeAbleToInitializeInstance() throws Exception {
        unit.init("glob", "I");
    }

    @Test
    public void shouldReturnRomanValueForSeriesOfValuesPassed1() throws Exception {
        unit.init("glob", "I");
        String romanVal = unit.getRoman(new String[]{"glob", "glob"});
        Assert.assertEquals("II", romanVal);
    }

    @Test
    public void shouldReturnRomanValueForSeriesOfValuesPassed2() throws Exception {
        unit.init("prok", "V");
        unit.init("glob", "I");
        String romanVal = unit.getRoman(new String[]{"prok", "glob"});
        Assert.assertEquals("VI", romanVal);
    }
}
