package com.sandy.programs.numbertoroman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gondals on 18/09/16.
 */
public class NumberToRomanConverter {

    private static final Map<Integer, String> ROMAN_CONSTANTS = new HashMap<>();
    private static final List<Integer> sortedRomanConstants;

    static {
        ROMAN_CONSTANTS.put(1, "I");
        ROMAN_CONSTANTS.put(4, "IV");
        ROMAN_CONSTANTS.put(5, "V");
        ROMAN_CONSTANTS.put(9, "IX");
        ROMAN_CONSTANTS.put(10, "X");
        ROMAN_CONSTANTS.put(40, "XL");
        ROMAN_CONSTANTS.put(50, "L");
        ROMAN_CONSTANTS.put(90, "XC");
        ROMAN_CONSTANTS.put(100, "C");
        ROMAN_CONSTANTS.put(400, "CD");
        ROMAN_CONSTANTS.put(500, "D");
        ROMAN_CONSTANTS.put(900, "CM");
        ROMAN_CONSTANTS.put(1000, "M");
    }

    static {
        sortedRomanConstants = ROMAN_CONSTANTS.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

    public static NumberToRomanConverter getInstance() {
        return new NumberToRomanConverter();
    }

    public String convert(final int input) {
        validate(input);

        String roman = "";
        int t = input;
        while(t > 0) {
            int i = getMaxFor(t);
            roman += ROMAN_CONSTANTS.get(i);
            t = t - i;
        }

        return roman;
    }

    private int getMaxFor(final int t) {
        for (Integer i : sortedRomanConstants)
            if (i <= t)
                return i;
        return 1;
    }

    private void validate(final int input) {
        if (input < 1)
            throw new IllegalArgumentException("Invalid Input");
    }
}
