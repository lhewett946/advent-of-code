package net.lsmith946.adventofcode.problems2023;

import net.lsmith946.adventofcode.problems2023.days.*;
import net.lsmith946.adventofcode.utils.ExitCodes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class AdventOfCode2023 {

    public static void main (String [] args) throws URISyntaxException, InterruptedException {
        try {
            Day1 d1 = new Day1();
            d1.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 1!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 1!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day2 d2 = new Day2();
            d2.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 2!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 2!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day3 d3 = new Day3();
            d3.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 3!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 3!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day4 d4 = new Day4();
            d4.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 4!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 4!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day5 d5 = new Day5();
            d5.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 5!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 5!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day6 d6 = new Day6();
            d6.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 6!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 6!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day7 d7 = new Day7();
            d7.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 7!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 7!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        }
    }
}
