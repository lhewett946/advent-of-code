package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Day7 implements Puzzle<Long> {

    private String values;
    private Map<Integer, Integer> crabSubmarinesAtPosition;

    public Day7() throws IOException {
        this.values = InputLoader.loadToString("/2021/day7_input.txt");
    }

    private void parseInput() {
        String[] ages = values.split(",");
        crabSubmarinesAtPosition = new HashMap<>();
        for(String s : ages) {
            int position = Integer.parseInt(s);
            if (crabSubmarinesAtPosition.containsKey(position)) {
                int currentSubmarines = crabSubmarinesAtPosition.get(position) + 1;
                crabSubmarinesAtPosition.replace(position, currentSubmarines);
            } else {
                crabSubmarinesAtPosition.put(position, 1);
            }
        }
    }

    @Override
    public Long solvePartOne() {
        parseInput();
        long minFuelUsed = Integer.MAX_VALUE;
        Set<Integer> allPositions = crabSubmarinesAtPosition.keySet();
        int startPositionTest = Collections.min(allPositions);
        int stopPositionTest = Collections.max(allPositions);
        for(int target = startPositionTest; target <= stopPositionTest; target++) {
            int totalFuelUsed = 0;
            for(Integer pos : allPositions) {
                totalFuelUsed += Math.abs(target - pos) * crabSubmarinesAtPosition.get(pos);
            }
            if (totalFuelUsed < minFuelUsed) {
                minFuelUsed = totalFuelUsed;
            }
        }
        System.out.println("The minimum fuel needed to align the submarines is " + minFuelUsed);
        return minFuelUsed;
    }

    @Override
    public Long solvePartTwo() {
        parseInput();
        long minFuelUsed = Integer.MAX_VALUE;
        Set<Integer> allPositions = crabSubmarinesAtPosition.keySet();
        int startPositionTest = Collections.min(allPositions);
        int stopPositionTest = Collections.max(allPositions);
        for(int target = startPositionTest; target <= stopPositionTest; target++) {
            int totalFuelUsed = 0;
            for(Integer pos : allPositions) {
                int delta = Math.abs(target - pos);
                totalFuelUsed += ((delta * (delta+1)) / 2) * crabSubmarinesAtPosition.get(pos);
            }
            if (totalFuelUsed < minFuelUsed) {
                minFuelUsed = totalFuelUsed;
            }
        }
        System.out.println("The minimum fuel needed to align the submarines is " + minFuelUsed);
        return minFuelUsed;
    }
}
