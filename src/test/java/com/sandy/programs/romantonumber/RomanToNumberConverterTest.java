package com.sandy.programs.romantonumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gondals on 18/09/16.
 */
public class RomanToNumberConverterTest {

    private RomanToNumberConverter unit;

    @Before
    public void setUp() throws Exception {
        unit = RomanToNumberConverter.getInstance();
    }

    @Test
    public void shouldAcceptRomanNumber() throws Exception {
        unit.convert("III");
    }

    @Test
    public void shouldReturnInteger() throws Exception {
        int number = unit.convert("III");
    }

    @Test
    public void shouldReturnNumberForSingleDigit() throws Exception {
        executeAndVerify("I", 1);
        executeAndVerify("II", 2);
        executeAndVerify("III", 3);
        executeAndVerify("IV", 4);
        executeAndVerify("V", 5);
        executeAndVerify("VI", 6);
        executeAndVerify("VII", 7);
        executeAndVerify("VIII", 8);
        executeAndVerify("IX", 9);
    }

    @Test
    public void shouldReturnNumberForDoubleDigits() throws Exception {
//        executeAndVerify("X", 10);
//        executeAndVerify("LXV", 65);
//        executeAndVerify("XCIV", 94);
//        executeAndVerify("M", 1000);
//        executeAndVerify("MMXII", 2012);
//        executeAndVerify("MCMXLIV", 1944);
//        executeAndVerify("XXXIX", 39);
        executeAndVerify("MCMIII", 1903);
    }

    private void executeAndVerify(final String roman, final int expectedNumber) {
        int actualNumber = unit.convert(roman);
        assertEquals(expectedNumber, actualNumber);
    }
}
