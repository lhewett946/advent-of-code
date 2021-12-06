package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day6 implements Puzzle {

    private String values;
    private long[] initialAges;

    public Day6() throws IOException {
        this.values = InputLoader.loadToString("/2021/day6_input.txt");
    }

    private void parseInput() {
        String[] ages = values.split(",");
        initialAges = new long[9];
        Arrays.fill(initialAges, 0);
        for(String s : ages) {
            initialAges[Integer.parseInt(s)]++;
        }
    }

    @SuppressWarnings("SuspiciousSystemArraycopy")
    private void processDay() {
        long newLanternfish = initialAges[0];
        System.arraycopy(initialAges, 1, initialAges, 0, 8);
        // each lanternfish that created a new fish now sets its timer to 6
        initialAges[6] += newLanternfish;

        // new lanternfish take 8 days to reproduce
        initialAges[8] = newLanternfish;
    }

    @Override
    public long solvePartOne() {
        parseInput();
        for(int day = 0; day < 80; day++) {
            processDay();
        }
        long totalFish = Arrays.stream(initialAges).sum();
        System.out.println("After 80 days, there are " + totalFish + " lanternfish");
        return totalFish;
    }

    @Override
    public long solvePartTwo() {
        parseInput();
        for(int day = 0; day < 256; day++) {
            processDay();
        }
        long totalFish = Arrays.stream(initialAges).sum();
        System.out.println("After 256 days, there are " + totalFish + " lanternfish");
        return totalFish;
    }
}
