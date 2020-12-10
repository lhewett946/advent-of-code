package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Day10 implements Puzzle {

    Set<Integer> values;

    public Day10() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToIntSet("/2020/day10_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 10 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int oneJoltDifferences = 0;
        int threeJoltDifferences = 0;
        int previousAdapterJoltage = 0;
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);
        for (Integer adaptorJoltage : sortedValues) {
            if (adaptorJoltage - previousAdapterJoltage == 1) {
                oneJoltDifferences++;
            } else if (adaptorJoltage - previousAdapterJoltage == 3) {
                threeJoltDifferences++;
            }
            previousAdapterJoltage = adaptorJoltage;
        }
        // plus one to the number of three jolt differences to include the adapter in your device
        threeJoltDifferences++;
        System.out.println("The number of one jolt differences multiplied by the number of three jolt differences is: " + (oneJoltDifferences * threeJoltDifferences));
        return (long) oneJoltDifferences * threeJoltDifferences;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
