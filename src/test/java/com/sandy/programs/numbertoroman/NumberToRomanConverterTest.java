package com.sandy.programs.numbertoroman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gondals on 18/09/16.
 */
public class NumberToRomanConverterTest {

    private NumberToRomanConverter unit;

    @Before
    public void setUp() throws Exception {
        unit = NumberToRomanConverter.getInstance();
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInvalidInput() throws Exception {
        unit.convert(0);
        unit.convert(-123);
    }

    @Test
    public void shouldReturnRomanForSingleDigit() throws Exception {
        executeAndVerify(1, "I");
        executeAndVerify(2, "II");
        executeAndVerify(3, "III");
        executeAndVerify(4, "IV");
        executeAndVerify(5, "V");
        executeAndVerify(6, "VI");
        executeAndVerify(7, "VII");
        executeAndVerify(8, "VIII");
        executeAndVerify(9, "IX");
    }

    @Test
    public void shouldReturnRomanForDoubleDigits() throws Exception {
        executeAndVerify(10, "X");
        executeAndVerify(11, "XI");
        executeAndVerify(14, "XIV");
        executeAndVerify(18, "XVIII");
        executeAndVerify(20, "XX");
        executeAndVerify(39, "XXXIX");
        executeAndVerify(40, "XL");
        executeAndVerify(49, "XLIX");
        executeAndVerify(50, "L");
        executeAndVerify(99, "XCIX");
    }

    @Test
    public void shouldReturnRomanForThreeDigits() throws Exception {
        executeAndVerify(100, "C");
        executeAndVerify(450, "CDL");
        executeAndVerify(599, "DXCIX");
        executeAndVerify(999, "CMXCIX");
    }

    @Test
    public void shouldReturnRomanForFourDigits() throws Exception {
//        executeAndVerify(1000, "M");
//        executeAndVerify(1234, "MCCXXXIV");
//        executeAndVerify(4321, "MMMMCCCXXI");
        executeAndVerify(1903, "MCMIII");
    }

    private void executeAndVerify(final int input, final String expectedRoman) {
        String actualRoman = unit.convert(input);
        assertEquals(expectedRoman, actualRoman);
    }
}
