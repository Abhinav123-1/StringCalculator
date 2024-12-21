package com.project.stringcalculator.service;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] numbersArray = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String number : numbersArray) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negatives.append(num).append(" ");
            } else {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString().trim());
        }
        return sum;
    }

}
