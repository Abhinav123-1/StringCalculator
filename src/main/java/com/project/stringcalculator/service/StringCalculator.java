package com.project.stringcalculator.service;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numbersArray = numbers.split(",");
        if(numbersArray.length == 1) {
            return Integer.parseInt(numbersArray[0]);
        }
        return Integer.parseInt(numbersArray[0]) + Integer.parseInt(numbersArray[1]);
    }
}
