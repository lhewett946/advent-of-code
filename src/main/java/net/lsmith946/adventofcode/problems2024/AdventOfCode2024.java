package net.lsmith946.adventofcode.problems2024;

import net.lsmith946.adventofcode.problems2024.days.*;
import net.lsmith946.adventofcode.utils.ExitCodes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class AdventOfCode2024 {

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
    }
}