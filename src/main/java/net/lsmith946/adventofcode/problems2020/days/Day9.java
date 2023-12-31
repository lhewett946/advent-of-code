package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import net.lsmith946.adventofcode.utils.SumUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Day9 implements Puzzle<Long> {

    List<Long> values;

    public Day9() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadToLongList(2020, 9);
    }

    @Override
    public Long solvePartOne() {
        List<Long> valuesInWindow = new ArrayList<>();
        for (Long l : values) {
            if (valuesInWindow.size() < 25) {
                valuesInWindow.add(l);
            } else {
                Set<Long> longsToMakeNewValue = SumUtils.findUniqueLongsToSumTo(l, 2, new HashSet<>(valuesInWindow));
                if (longsToMakeNewValue.isEmpty()) {
                    System.out.println("The first number that is not the sum of two numbers in the window is " + l);
                    return l;
                } else {
                    valuesInWindow.remove(0);
                    valuesInWindow.add(l);
                }
            }
        }
        return (long) -1;
    }

    @Override
    public Long solvePartTwo() {
        long targetValue = solvePartOne();
        for (int i = 0; i < values.size(); i++) {
            long runningTotal = values.get(i);
            Set<Long> valuesInRange = new HashSet<>();
            valuesInRange.add(values.get(i));
            for (int j = i + 1; j < values.size(); j++) {
                runningTotal += values.get(j);
                valuesInRange.add(values.get(j));
                if (runningTotal == targetValue) {
                    long weakness = Collections.min(valuesInRange) + Collections.max(valuesInRange);
                    System.out.println("The encryption weakness is: " + weakness);
                    return weakness;
                } else if (runningTotal > targetValue) {
                    break;
                }
            }
        }
        return (long) -1;
    }
}
