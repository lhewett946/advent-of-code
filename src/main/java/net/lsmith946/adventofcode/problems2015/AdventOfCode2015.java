package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.problems2015.days.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AdventOfCode2015 {

    private static final int FILE_NOT_FOUND_EXCEPTION_EXIT_CODE = 1;
    private static final int IO_EXCEPTION_EXIT_CODE = 2;
    private static final int ALGORITHM_EXCEPTION_EXIT_CODE = 3;

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
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Tried to use an invalid hashing algorithm for Day 4!");
            System.exit(ALGORITHM_EXCEPTION_EXIT_CODE);
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
    }
}
