package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day1 implements Puzzle {

    private List<String> values;

    public Day1() throws IOException {
        this.values = InputLoader.loadToStringList("/2022/day1_input.txt");
    }

    @Override
    public long solvePartOne() {
        // part 1 is to find the highest total number of calories carried by a single elf
        long elfCalories = 0;
        long maxCalories = 0;
        for (String s : values) {
            // on empty string
            if (s.isEmpty()) {
                if (elfCalories > maxCalories) {
                    maxCalories = elfCalories;
                }
                elfCalories = 0;
            } else {
                elfCalories += Integer.parseInt(s);
            }
        }
        System.out.println("The maximum number of calories carried by a single elf is " + maxCalories);
        return maxCalories;
    }

    @Override
    public long solvePartTwo() {
        // part 2 is to find three integers from the list which sum to 2020
        return 0;
    }
}
