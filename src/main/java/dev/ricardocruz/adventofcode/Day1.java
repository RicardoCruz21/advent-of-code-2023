package dev.ricardocruz.adventofcode;

import dev.ricardocruz.adventofcode.util.PuzzleInputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {

    public static void main(String[] args) {

        List<String> linesOfText = PuzzleInputReader.readPuzzleInput("data\\day-01.txt");
        //System.out.println(partOne(linesOfText));
        System.out.println(partTwo(linesOfText));
    }

    public static int partOne(List<String> linesOfText) {
        int sumOfCalibratedValues = 0;

        for (String line: linesOfText) {
            boolean firstDigitFound = false;
            boolean lastDigitFound = false;
            boolean digitsFound = false;

            char firstDigit = ' ';
            char lastDigit = ' ';

            int start = 0;
            int end = line.length() - 1;

            while (!digitsFound) {
                char first = line.charAt(start);
                char last = line.charAt(end);

                if (Character.isDigit(first)) {
                    firstDigit = first;
                    firstDigitFound = true;
                }

                if (Character.isDigit(last)) {
                    lastDigit = last;
                    lastDigitFound = true;
                }

                if (!firstDigitFound) start++;
                if (!lastDigitFound) end--;

                digitsFound = firstDigitFound && lastDigitFound;
            }

            String stringValue = Character.toString(firstDigit) + lastDigit;
            int numericValue = Integer.parseInt(stringValue);
            sumOfCalibratedValues += numericValue;
            //System.out.println(numericValue);
        }

        return sumOfCalibratedValues;
    }

    public static int partTwo(List<String> linesOfText) {
        int sumOfCalibaratedValues = 0;

        Map<String, Integer> wordNumbers = new HashMap<>();
        wordNumbers.put("one", 1);
        wordNumbers.put("two", 2);
        wordNumbers.put("three", 3);
        wordNumbers.put("four", 4);
        wordNumbers.put("five", 5);
        wordNumbers.put("six", 6);
        wordNumbers.put("seven", 7);
        wordNumbers.put("eight", 8);
        wordNumbers.put("nine", 9);

        for (String line: linesOfText) {

            System.out.println(line);
            Map<Integer, Integer> indexesOfDigits = new HashMap<>();

            for (Map.Entry<String, Integer> word: wordNumbers.entrySet()) {
                if (line.contains(word.getKey())) {
                    for (int i = 0; i <= line.length() - word.getKey().length(); i++) {
                        String testWord = line.substring(i, i + word.getKey().length());
                        if (testWord.equals(word.getKey())) {
                            indexesOfDigits.put(i, word.getValue());
                        }
                    }
                    //indexesOfDigits.put(line.indexOf(word.getKey()), word.getValue());
                }
            }

            for (int i = 0; i < line.length(); i++) {
                char value = line.charAt(i);
                if (Character.isDigit(value)) {
                    indexesOfDigits.put(i, Integer.parseInt(Character.toString(value)));
                }
            }
            System.out.println(indexesOfDigits);

            int lowestIndex = line.length() - 1;
            int highestIndex = 0;
            int firstDigit = 0;
            int lastDigit = 0;

            for (Map.Entry<Integer, Integer> digit: indexesOfDigits.entrySet()) {
                if (digit.getKey() <= lowestIndex) {
                    firstDigit = digit.getValue();
                    lowestIndex = digit.getKey();
                }
                if (digit.getKey() >= highestIndex) {
                    lastDigit = digit.getValue();
                    highestIndex = digit.getKey();
                }
            }

            String stringValue = Integer.toString(firstDigit) + lastDigit;
            int numericValue = Integer.parseInt(stringValue);
            sumOfCalibaratedValues += numericValue;
            System.out.println(numericValue);
        }

        return sumOfCalibaratedValues;
    }
}
