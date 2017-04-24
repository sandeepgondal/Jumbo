package com.sandy.programs.pro1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gondals on 18/09/16.
 */
public class RomanToNumberConverterTest {

    private RomanToNumberConverter romanToNumberConverter;

    @Before
    public void setUp() throws Exception {
        romanToNumberConverter = RomanToNumberConverter.getInstance();
    }

    @Test
    public void shouldAcceptRomanNumber() throws Exception {
        romanToNumberConverter.convert("II");
    }

    @Test
    public void shouldReturnIntValue() throws Exception {
        int number = romanToNumberConverter.convert("II");
    }

    @Test
    public void shouldConvertIto1() throws Exception {
        convertAndVerify("I", 1);
    }

    @Test
    public void shouldConvertIITo2() throws Exception {
        convertAndVerify("II", 2);
    }

    @Test
    public void shouldConvertIVTo4() throws Exception {
        convertAndVerify("IV", 4);
    }

    @Test
    public void shouldConvertVTo5() throws Exception {
        convertAndVerify("V", 5);
    }

    @Test
    public void shouldConvertVITo6() throws Exception {
        convertAndVerify("VI", 6);
    }

    @Test
    public void shouldConvertIXTo9() throws Exception {
        convertAndVerify("IX", 9);
    }

    @Test
    public void shouldConvertXLVTo45() throws Exception {
        convertAndVerify("XLV", 45);
    }

    @Test
    public void randomChecks() throws Exception {
        convertAndVerify("MMMCMX", 3910);
        convertAndVerify("MMMMDXLV", 4545);
        convertAndVerify("MMMMCCCXXI", 4321);
    }

    private void convertAndVerify(final String roman, final int expectedNumber) {
        int actualNumber = romanToNumberConverter.convert(roman);
        Assert.assertEquals(expectedNumber, actualNumber);
    }
}
