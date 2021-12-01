package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import net.lsmith946.adventofcode.utils.SumUtils;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Day1 implements Puzzle {

    private List<Long> values;

    public Day1() throws IOException {
        this.values = InputLoader.loadToLongList("/2021/day1_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 1 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int timesIncreased = 0;
        long previousValue = values.get(0);
        for(Long l : values) {
            if (l > previousValue)
                timesIncreased++;
            previousValue = l;
        }
        System.out.println("The number of times that the depth measurement increased is " + timesIncreased);
        return timesIncreased;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
