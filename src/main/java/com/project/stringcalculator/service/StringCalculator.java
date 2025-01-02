package com.project.stringcalculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String CUSTOM_DELIMETER = "//";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if (numbers.startsWith(CUSTOM_DELIMETER)) {
            int delimiterIndex = numbers.indexOf(NEW_LINE);
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] numbersArray = numbers.split(delimiter);
        validateNumbers(numbersArray);
        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }

    private void validateNumbers(String[] numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.add(num);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers.stream().map(m -> m.toString()).collect(Collectors.joining(" ")));
        }
    }

}
