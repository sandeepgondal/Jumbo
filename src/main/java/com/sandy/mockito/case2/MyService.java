package com.sandy.mockito.case2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gondals on 28/08/16.
 */

@Component
public class MyService {

    @Autowired private MyExternalService myExternalService;

    public String greetUser(final String userName, final int age) {
        return "Hello " + myExternalService.returnInitials(age) + userName;
    }

    public MyExternalService getMyExternalService() {
        return myExternalService;
    }

    public void setMyExternalService(final MyExternalService myExternalService) {
        this.myExternalService = myExternalService;
    }
}
