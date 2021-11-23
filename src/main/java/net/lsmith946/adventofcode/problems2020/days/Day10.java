package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.problems2020.Adapter;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day10 implements Puzzle {

    List<Integer> sortedValues;
    Map<Integer, Adapter> adapters;

    public Day10() throws IOException {
        Set<Integer> temporarySet;
        // load to an integer set to ensure no duplicates (as this is assumed by other code)
        temporarySet = InputLoader.loadToIntSet("/2020/day10_input.txt");
        // copy values to a list and sort them
        sortedValues = new ArrayList<>(temporarySet);
        Collections.sort(sortedValues);
    }

    private void loadAdaptors() {
        adapters = new HashMap<>();
        for (Integer joltage : sortedValues) {
            Adapter a = new Adapter(joltage);
            adapters.put(joltage, a);
        }
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
        for (Integer adaptorJoltage : this.sortedValues) {
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
        loadAdaptors();
        for (Integer joltage : sortedValues) {
            Adapter currentAdapter = adapters.get(joltage);
            for (Integer driveJoltage : currentAdapter.getJoltageCanDrive()) {
                Adapter drivenAdapter = adapters.get(driveJoltage);
                if (drivenAdapter != null) {
                    drivenAdapter.addPathsToReach(currentAdapter.getPathsToReach());
                }
            }
        }
        // get the number of ways to reach the final outlet
        Adapter finalAdapter = adapters.get(sortedValues.get(sortedValues.size() - 1));
        System.out.println("Way to reach the final adapter: " + finalAdapter.getPathsToReach());
        return finalAdapter.getPathsToReach();
    }
}
