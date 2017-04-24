package com.sandy.programs.pro1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gondals on 18/09/16.
 */
public class RomanMappingHolder {

    private final Map<String, String> nameRomanMaps = new HashMap<>();

    public static RomanMappingHolder getInstance() {
        return new RomanMappingHolder();
    }

    public void init(final String name, final String romanValue) {
        nameRomanMaps.put(name, romanValue);
    }

    public String getRoman(final String[] names) {
        String roman = "";

        for (String name : names)
            roman += nameRomanMaps.get(name);

        return roman;
    }
}
