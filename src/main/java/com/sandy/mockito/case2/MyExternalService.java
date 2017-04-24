package com.sandy.mockito.case2;

import org.springframework.stereotype.Component;

/**
 * Created by gondals on 28/08/16.
 */

@Component
public class MyExternalService {

    public String returnInitials(final int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be less than 0");
        else if (age >= 18) {
            return "Mr. ";
        } else {
            return "Master. ";
        }
    }

}
