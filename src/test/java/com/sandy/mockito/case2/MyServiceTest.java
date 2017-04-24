package com.sandy.mockito.case2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gondals on 28/08/16.
 */
public class MyServiceTest {

    @Mock private MyExternalService myExternalService;
    @InjectMocks private MyService myService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCorrectGreetingForUSerWithAgeLessThan18() throws Exception {
        final int age = 16;
        when(myExternalService.returnInitials(age)).thenReturn("Master. ");
        assertEquals("Hello Master. Sachin", myService.greetUser("Sachin", age));
    }

    @Test
    public void shouldReturnCorrectGreetingForUSerWithAgeGreaterThanEqualTo18() throws Exception {
        final int age = 18;
        doReturn("Master. ").when(myExternalService).returnInitials(age);
        assertEquals("Hello Master. Sandeep", myService.greetUser("Sandeep", age));
    }

    @Test
    public void shouldVerifyIfExternalServiceMethodIsCalled() throws Exception {
        int age = 34;
        myService.greetUser("Sandeep", age);
        verify(myExternalService).returnInitials(age); // Checks if method called once with exact argument.
        verify(myExternalService).returnInitials(anyInt()); // Checks if method is called once with any argument.
        verify(myExternalService, times(1)).returnInitials(anyInt()); // Checks if method is called for specified number of times.
    }

    @Test
    public void shouldVerifyIfCorrectArgumentIsPassedToExternalService() throws Exception {
        int age = 34;
        myService.greetUser("Sandeep", age);
        ArgumentCaptor<Integer> ageCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(myExternalService).returnInitials(ageCaptor.capture());
        assertEquals(age, ageCaptor.getValue().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInvalidDateIsPassed() throws Exception {
        int age = -1;
        doThrow(IllegalArgumentException.class).when(myExternalService).returnInitials(age);
        myService.greetUser("Some Name", age);
    }

    @Test
    public void shouldGreetForDifferentAgeUsers() throws Exception {
        doAnswer( o -> {
            int age = o.getArgumentAt(0, Integer.class);
            if (age < 5)
                return "Kid. ";
            else if (age < 10)
                return "Big Kid. ";
            else if (age < 18)
                return "Master. ";
            else
                return "Mr. ";
        }).when(myExternalService).returnInitials(anyInt());

        assertEquals("Hello Kid. Vivaan", myService.greetUser("Vivaan", 4));
        assertEquals("Hello Big Kid. Soham", myService.greetUser("Soham", 9));
        assertEquals("Hello Master. Sachin", myService.greetUser("Sachin", 14));
        assertEquals("Hello Mr. Saurabh", myService.greetUser("Saurabh", 18));
    }

    @Test
    public void shouldReturnMultipleCallsWithDifferentValues() throws Exception {
        when(myExternalService.returnInitials(anyInt()))
                .thenReturn("Hey Dude. ")
                .thenReturn("Dude Dude. ");

        assertEquals("Hello Hey Dude. Sandeep", myService.greetUser("Sandeep", 23));
        assertEquals("Hello Dude Dude. Sandeep", myService.greetUser("Sandeep", 2));
        assertEquals("Hello Dude Dude. Sandeep", myService.greetUser("Sandeep", 23));
        assertEquals("Hello Dude Dude. Sandeep", myService.greetUser("Sandeep", 2));
    }
}
