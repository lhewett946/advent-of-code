package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import net.lsmith946.adventofcode.utils.SumUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 implements Puzzle {

    List<Long> values;

    public Day9() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToLongList("/2020/day9_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 9 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
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
        return -1;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
