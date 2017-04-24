package com.sandy.mockito.case2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gondals on 28/08/16.
 */


public class MyServiceEndToEndTest {

    private MyService myService;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        myService = classPathXmlApplicationContext.getBean(MyService.class);
    }

    @Test
    public void shouldReturnCorrectGreetingMessageForUserAgeLessThan18() throws Exception {
        Assert.assertEquals("Hello Mr. Sandeep", myService.greetUser("Sandeep", 34));
    }

    @Test
    public void shouldReturnCorrectGreetingMessageForUserAgeGreaterThanEqualTo18() throws Exception {
        Assert.assertEquals("Hello Master. Sachin", myService.greetUser("Sachin", 16));
    }
}
