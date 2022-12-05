package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.Puzzle;

import java.util.HashMap;
import java.util.Map;

public class Day15 implements Puzzle<Integer> {

    @Override
    public Integer solvePartOne() {
        Map<Integer, Integer> previousValues = new HashMap<>();
        previousValues.put(1, 1);
        previousValues.put(2, 2);
        previousValues.put(16, 3);
        previousValues.put(19, 4);
        previousValues.put(18, 5);
        int lastSpokenNumber = 0;
        for (int turn = 6; turn < 2020; turn++) {
            // find out the turn when the last spoken number was previously spoken
            // and update the map to show it was spoken on the current turn
            Integer turnNumberLastSpoken = previousValues.put(lastSpokenNumber, turn);
            if (turnNumberLastSpoken == null) {
                lastSpokenNumber = 0;
            } else {
                lastSpokenNumber = turn - turnNumberLastSpoken;
            }
        }
        System.out.println("The 2020th number spoken is: " + lastSpokenNumber);
        return lastSpokenNumber;
    }

    @Override
    public Integer solvePartTwo() {
        Map<Integer, Integer> previousValues = new HashMap<>();
        previousValues.put(1, 1);
        previousValues.put(2, 2);
        previousValues.put(16, 3);
        previousValues.put(19, 4);
        previousValues.put(18, 5);
        int lastSpokenNumber = 0;
        for (int turn = 6; turn < 30000000; turn++) {
            // find out the turn when the last spoken number was previously spoken
            // and update the map to show it was spoken on the current turn
            Integer turnNumberLastSpoken = previousValues.put(lastSpokenNumber, turn);
            if (turnNumberLastSpoken == null) {
                lastSpokenNumber = 0;
            } else {
                lastSpokenNumber = turn - turnNumberLastSpoken;
            }
        }
        System.out.println("The 30000000th number spoken is: " + lastSpokenNumber);
        return lastSpokenNumber;
    }
}
