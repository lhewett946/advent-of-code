package net.lsmith946.adventofcode.problems2024.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Day2 implements Puzzle<Long> {

    List<String> values;

    public Day2() throws IOException, URISyntaxException, InterruptedException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList(2024, 2);
    }

    private boolean isSafe(String[] levels) {
        boolean increasing = false;
        boolean safe = true;
        int previousLevel;
        previousLevel = Integer.parseInt(levels[0]);
        for(int i = 1; i < levels.length; i++) {
            int nextLevel = Integer.parseInt(levels[i]);
            if (Math.abs(nextLevel - previousLevel) < 1 || Math.abs(nextLevel - previousLevel) > 3)
                safe =  false;
            if (i == 1) {
                // first time around the loop, determine if increasing or decreasing report
                if (nextLevel > previousLevel) increasing = true;
                else increasing = false;
            } else if ((nextLevel > previousLevel) != increasing) {
                safe = false;
            }
            previousLevel = nextLevel;
        }
        return safe;
    }

    @Override
    public Long solvePartOne() {
        long count = 0L;
        for(String report : values) {
            String[] levels;
            levels = report.split(" ");
            if (isSafe(levels)) count++;
        }
        System.out.println("The number of safe reports is " + count);
        return count;
    }

    @Override
    public Long solvePartTwo() {
        long count = 0L;

        return count;
    }
}
