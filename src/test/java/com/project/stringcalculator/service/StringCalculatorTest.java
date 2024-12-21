package com.project.stringcalculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void testEmptyStringValueShouldGiveZero(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

}
