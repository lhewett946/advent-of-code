package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 implements Puzzle {

    private List<String> values;
    private List<Long> perElfCalories;

    private void calculateElfCalories() {
        long elfCalories = 0;
        for (String s : values) {
            // on empty string
            if (s.isEmpty()) {
                perElfCalories.add(elfCalories);
                elfCalories = 0;
            } else {
                elfCalories += Integer.parseInt(s);
            }
        }
    }

    public Day1() throws IOException {
        perElfCalories = new ArrayList<>();
        this.values = InputLoader.loadToStringList("/2022/day1_input.txt");
        calculateElfCalories();
        perElfCalories.sort(Comparator.reverseOrder());
    }

    @Override
    public long solvePartOne() {
        // part 1 is to find the highest total number of calories carried by a single elf
        long maxCalories = perElfCalories.get(0);
        System.out.println("The maximum number of calories carried by a single elf is " + maxCalories);
        return maxCalories;
    }

    @Override
    public long solvePartTwo() {
        // part 2 is to find the total calories carried by the three elves with the most calories
        long totalCalories = perElfCalories.get(0) + perElfCalories.get(1) + perElfCalories.get(2);
        System.out.println("The three elves carrying the most calories are carrying a total of " + totalCalories + " calories");
        return totalCalories;
    }
}
