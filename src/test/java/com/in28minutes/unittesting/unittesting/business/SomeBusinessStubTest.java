package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.*;

class SomeDataServiceStub implements SomeDataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataServiceTest() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService( new SomeDataServiceStub() );
        int actualResult = business.calculateSumUsingDataService( );
        int expectedResult = 6;
        assertEquals( expectedResult, actualResult );
    }

}