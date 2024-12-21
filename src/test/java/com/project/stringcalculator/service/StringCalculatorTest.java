package com.project.stringcalculator.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
         stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    void testEmptyStringValueShouldGiveZero(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testSingleStringValueShouldGiveSameValue(){
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void testTwoValuesShouldGiveTheSum(){
        assertEquals(3,stringCalculator.add("1,2"));
    }

    @Test
    void testMultipleValuesShouldGiveTheSumOfValues(){
        assertEquals(6,stringCalculator.add("1,2,3"));
    }

    @Test
    void testNewlineDelimiters() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiters() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-2,3,-4"));
        assertEquals("Negatives not allowed: -2 -4", exception.getMessage());
    }

}
