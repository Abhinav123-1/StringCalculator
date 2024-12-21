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

}
