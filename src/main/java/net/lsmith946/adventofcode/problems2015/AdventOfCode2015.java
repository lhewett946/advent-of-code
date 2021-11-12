package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.problems2015.days.Day1;
import net.lsmith946.adventofcode.problems2015.days.Day2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AdventOfCode2015 {

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
            System.err.println("Unable to open input data file for Day 1!");
            System.exit(FILE_NOT_FOUND_EXCEPTION_EXIT_CODE);
        } catch (IOException e) {
            System.err.println("Unable to read input file for Day 1!");
            System.exit(IO_EXCEPTION_EXIT_CODE);
        }
    }
}
