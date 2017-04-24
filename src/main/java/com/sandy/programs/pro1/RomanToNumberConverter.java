package com.sandy.programs.pro1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gondals on 18/09/16.
 */
public class RomanToNumberConverter {

    private static final Map<String, Integer> ROMAN_CONSTANTS = new HashMap<>();
    static {
        ROMAN_CONSTANTS.put("I", 1);
        ROMAN_CONSTANTS.put("V", 5);
        ROMAN_CONSTANTS.put("X", 10);
        ROMAN_CONSTANTS.put("L", 50);
        ROMAN_CONSTANTS.put("C", 100);
        ROMAN_CONSTANTS.put("D", 500);
        ROMAN_CONSTANTS.put("M", 1000);
    }

    public static RomanToNumberConverter getInstance() {
        return new RomanToNumberConverter();
    }

    public int convert(final String roman) {
        int answer = 0;
        int prevNumber = 0;
        for (int i = 0; i < roman.length(); i++) {
            Integer value = getValue(roman, i);
            Integer computedValue = getComputedValue(prevNumber, value);
            answer += computedValue;
            prevNumber = value;
        }

        return answer;
    }

    private Integer getComputedValue(final int prevNumber, final Integer value) {
        Integer computedValue = value;
        if (previousExists(prevNumber))
            if (isPreviousNumberSmaller(prevNumber, value)) {
                computedValue -= (2 * prevNumber);
            }
        return computedValue;
    }

    private boolean isPreviousNumberSmaller(final int prevNumber, final Integer value) {
        return prevNumber < value;
    }

    private boolean previousExists(final int prevNumber) {
        return prevNumber != 0;
    }

    private Integer getValue(final String roman, final int i) {
        String romanDigit = getRomanDigit(roman, i);
        return ROMAN_CONSTANTS.get(romanDigit);
    }

    private String getRomanDigit(final String roman, final int index) {
        return String.valueOf(roman.charAt(index));
    }
}
