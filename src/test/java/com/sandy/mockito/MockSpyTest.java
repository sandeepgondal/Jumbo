package com.sandy.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gondals on 27/08/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockSpyTest {

    @Mock List<String> mockString;
    @Spy ArrayList<String> spyString;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() throws Exception {
        System.out.println("--------------Mock");
        System.out.println(mockString.size());
        mockString.add("Hello Mock");
        System.out.println(mockString.size());
        System.out.println(mockString.get(0));
        Mockito.when(mockString.get(0)).thenReturn("Mocked Value");
        System.out.println(mockString.get(0));
        Mockito.doReturn("New Mocked Value").when(mockString).get(0);
        System.out.println(mockString.get(0));
    }

    @Test
    public void testSpy() throws Exception {
        System.out.println("--------------Spy");
        System.out.println(spyString.size());
        spyString.add("Hello Spy");
        System.out.println(spyString.size());
        System.out.println(spyString.get(0));
        Mockito.when(spyString.get(0)).thenReturn("Spied Value");
        System.out.println(spyString.get(0));
        Mockito.doReturn("New Spied Value").when(spyString).get(0);
        System.out.println(spyString.get(0));
    }
}
