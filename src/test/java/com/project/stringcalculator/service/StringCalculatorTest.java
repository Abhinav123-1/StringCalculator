package com.project.stringcalculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void testEmptyStringValueShouldGiveZero(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testSingleStringValueShouldGiveSameValue(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testTwoValuesShouldGiveTheSum(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(3,calculator.add("1,2"));
    }

    @Test
    void testMultipleValuesShouldGiveTheSumOfValues(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(6,calculator.add("1,2,3"));
    }

    @Test
    void testNewlineDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3,-4"));
        assertEquals("Negatives not allowed: -2 -4", exception.getMessage());
    }

}
