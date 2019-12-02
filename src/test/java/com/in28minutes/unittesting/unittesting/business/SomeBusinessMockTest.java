package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    @Test
    public void calculateSumUsingDataServiceTest() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn( new int[] { 1, 2, 3} );


        business.setSomeDataService( dataServiceMock );
        int actualResult = business.calculateSumUsingDataService( );
        int expectedResult = 6;
        assertEquals( expectedResult, actualResult );
    }

}