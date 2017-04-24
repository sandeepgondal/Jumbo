package com.sandy.programs.pro1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gondals on 18/09/16.
 */
public class CreditHolder {

    private Map<String, Double> metalToCreditMapper = new HashMap<>();

    private RomanMappingHolder romanMappingHolder;
    private RomanToNumberConverter romanToNumberConverter = RomanToNumberConverter.getInstance();

    public static CreditHolder getInstance(RomanMappingHolder romanMappingHolder) {
        CreditHolder creditHolder = new CreditHolder();
        creditHolder.setRomanMappingHolder(romanMappingHolder);
        return creditHolder;
    }

    public void init(final String[] strings, final String metal, final double credits) {
        String roman = romanMappingHolder.getRoman(strings);
        metalToCreditMapper.put(metal, credits / romanToNumberConverter.convert(roman));
    }

    public double convert(final String[] strings, final String metal) {
        String roman = romanMappingHolder.getRoman(strings);
        int romanIntValue = romanToNumberConverter.convert(roman);
        Double credit = metalToCreditMapper.get(metal);
        credit = credit == null ? 1 : credit;

        return romanIntValue * credit;
    }

    public void setRomanMappingHolder(final RomanMappingHolder romanMappingHolder) {
        this.romanMappingHolder = romanMappingHolder;
    }
}
