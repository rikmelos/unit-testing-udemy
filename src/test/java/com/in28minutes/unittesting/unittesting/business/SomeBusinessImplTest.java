package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Test
    public void calculateSumTest() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum( new int[] { 1, 2 ,3} );
        int expectedResult = 6;
        assertEquals( expectedResult, actualResult );
    }
}