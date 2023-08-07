package com.example.ecommerce;

import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testCountVowels() {
        String str = "Hello, World!";
        int expectedCount = 3;
        int actualCount = StringUtils.countVowels(str);
        assertEquals(expectedCount, actualCount);
    }
}
