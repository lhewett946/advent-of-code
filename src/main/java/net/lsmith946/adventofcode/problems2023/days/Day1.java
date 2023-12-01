package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Day1 implements Puzzle<Long> {

    List<String> values;

    public Day1() throws IOException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList("/2023/day1_input.txt");
    }

    @Override
    public Long solvePartOne() {
        Long sum = 0L;
        for(String s : values) {
            String onlyDigits = s.replaceAll("[^0-9]", "");
            String selectedDigits = String.valueOf(onlyDigits.charAt(0)) + String.valueOf(onlyDigits.charAt(onlyDigits.length()-1));
            sum += Long.parseLong(selectedDigits);
        }
        System.out.println("The sum of all the calibration values is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
