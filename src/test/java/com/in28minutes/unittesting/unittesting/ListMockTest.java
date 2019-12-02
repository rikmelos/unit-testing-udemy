package com.in28minutes.unittesting.unittesting;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock( List.class);

    @Test
    public void returnWithParameters() {
        when( mock.get(0) ).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0) );
        assertEquals( null , mock.get(1) );

    }

    @Test
    public void returnWithGenericParameters() {
        when( mock.get( anyInt() ) ).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0) );
        assertEquals( "in28Minutes" , mock.get(1) );

    }

    @Test
    public void verificationBasics() {

        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get( anyInt() );
    }

    @Test
    public void argumentCapturing() {

        mock.add( "SomeString" );

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass( String.class );
        verify(mock).add(captor.capture());
        assertEquals("SomeString", captor.getValue() );
    }

    @Test
    public void multipleArgumentCapturing() {

        mock.add( "SomeString1" );
        mock.add( "SomeString2" );

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass( String.class );
        verify(mock, times(2 )).add(captor.capture());

        List<String> allVallues = captor.getAllValues();

        assertEquals("SomeString1", allVallues.get( 0 ) );
        assertEquals("SomeString2", allVallues.get( 1 ) );
    }

    @Test
    public void mocking(){

        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println( arrayListMock.get(0) );//null
        System.out.println( arrayListMock.size() );//0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println( arrayListMock.size() );//0
        when( arrayListMock.size() ).thenReturn( 5 );
        System.out.println( arrayListMock.size() );//5
    }

    @Test
    public void spying(){

        ArrayList arrayListSpyt = spy(ArrayList.class);
        arrayListSpyt.add("Test0");
        System.out.println( arrayListSpyt.get(0) );//Test0
        System.out.println( arrayListSpyt.size() );//1
        arrayListSpyt.add("Test");
        arrayListSpyt.add("Test2");
        System.out.println( arrayListSpyt.size() );//3
        when( arrayListSpyt.size() ).thenReturn( 5 );
        System.out.println( arrayListSpyt.size() );//5

        arrayListSpyt.add("Test4");
        System.out.println( arrayListSpyt.size() );//5
        arrayListSpyt.add("Test5");
        System.out.println( arrayListSpyt.size() );//5

        verify( arrayListSpyt ).add("Test4");
    }
}
