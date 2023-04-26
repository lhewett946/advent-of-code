package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.problems2015.days.*;
import net.lsmith946.adventofcode.utils.ExitCodes;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AdventOfCode2015 {

    public static void main (String [] args) {
        try {
            Day1 d1 = new Day1();
            d1.solve();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open input data file for Day 1!");
            System.exit(ExitCodes.FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 1!");
            System.exit(ExitCodes.IO_EXCEPTION_EXIT_CODE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(ExitCodes.UNKNOWN_ERROR_EXIT_CODE);
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
        } catch (IllegalStateException e) {
            System.err.println("Tried to use an invalid hashing algorithm for Day 4!");
            System.exit(ExitCodes.ILLEGAL_STATE_EXCEPTION_EXIT_CODE);
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
    }
}
