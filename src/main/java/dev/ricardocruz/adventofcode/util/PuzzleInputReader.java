package dev.ricardocruz.adventofcode.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleInputReader {

    public static List<String> readPuzzleInput(String filePath) {

        List<String> linesOfText = new ArrayList<>();

        File puzzleFile = new File(filePath);

        try (Scanner fileInput = new Scanner(puzzleFile)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                linesOfText.add(lineOfText);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + puzzleFile.getAbsolutePath());
        }

        return linesOfText;
    }
}
