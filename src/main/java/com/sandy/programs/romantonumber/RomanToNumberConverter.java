package com.sandy.programs.romantonumber;

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

        int number = 0;
        int prev = 0;
        for (int i = 0; i < roman.length(); i++) {
            int value = getValue(roman, i);

            if (prev != 0)
                if (prev < value) {
                    number -= prev;
                    value = value - prev;
                }

            number += value;
            prev = value;
        }

        return number;
    }

    private int getValue(final String roman, final int i) {
        if (i >= roman.length())
            return 0;
        return ROMAN_CONSTANTS.get(String.valueOf(roman.charAt(i)));
    }
}
