package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Present;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 implements Puzzle {

    List<String> input;

    public Day2() throws IOException {
        InputLoader il = new InputLoader();
        this.input = il.loadToStringList("/2015/day2_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 2 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        // load the dimensions of the presents and calculate the amount of wrapping paper needed for each
        // of the presents
        long wrappingPaperNeeded = 0;
        for (String s : input) {
            int length;
            int width;
            int depth;
            String [] dimensions = s.split("x");
            length = Integer.parseInt(dimensions[0]);
            width = Integer.parseInt(dimensions[1]);
            depth = Integer.parseInt(dimensions[2]);
            Present p = new Present(length, width, depth);
            wrappingPaperNeeded += p.calculateWrappingPaperNeeded();
        }
        System.out.println("The elves need to order " + wrappingPaperNeeded + " square feet of wrapping paper");
        return wrappingPaperNeeded;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
