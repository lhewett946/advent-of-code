package net.lsmith946.adventofcode.problems2020;

import net.lsmith946.adventofcode.problems2020.days.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AdventOfCode2020 {

    private static final int FILE_NOT_FOUND_EXCEPTION_EXIT_CODE = 1;
    private static final int IO_EXCEPTION_EXIT_CODE = 2;

    public static void main (String [] args) {
        try {
            Day1 d1 = new Day1();
            d1.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 1!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 1!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day2 d2 = new Day2();
            d2.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 2!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 2!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day3 d3 = new Day3();
            d3.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 3!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 3!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day4 d4 = new Day4();
            d4.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 4!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 4!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day5 d5 = new Day5();
            d5.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 5!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 5!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day6 d6 = new Day6();
            d6.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 6!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 6!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day7 d7 = new Day7();
            d7.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 7!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 7!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day8 d8 = new Day8();
            d8.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 8!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 8!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day9 d9 = new Day9();
            d9.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 9!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 9!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day10 d10 = new Day10();
            d10.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 10!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 10!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day11 d11 = new Day11();
            d11.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 11!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 11!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day12 d12 = new Day12();
            d12.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 12!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 12!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }

        try {
            Day13 d13 = new Day13();
            d13.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 13!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 13!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }
    }
}
