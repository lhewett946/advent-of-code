package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day7 implements Puzzle {

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
    public long solvePartOne() {
        parseInput();
        int minFuelUsed = Integer.MAX_VALUE;
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
    public long solvePartTwo() {
        parseInput();
        return 0;
    }
}
