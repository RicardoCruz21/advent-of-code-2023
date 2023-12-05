package dev.ricardocruz.adventofcode;

import dev.ricardocruz.adventofcode.util.PuzzleInputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {

        List<String> linesOfText = PuzzleInputReader.readPuzzleInput("data\\day-01-test.txt");
        int sumOfCalibratedValues = partOne(linesOfText);

        /*
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter path to puzzle input: ");
        String filePath = userInput.nextLine();
        userInput.close();

        File puzzleFile = new File(filePath);

        try (Scanner fileInput = new Scanner(puzzleFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                linesOfText.add(lineOfText);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + puzzleFile.getAbsolutePath());
        }
        */


        System.out.println(sumOfCalibratedValues);
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
            System.out.println(numericValue);
        }

        return sumOfCalibratedValues;
    }
}
