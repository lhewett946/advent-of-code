package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day8 implements Puzzle {

    private List<String> values;

    public Day8() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day8_input.txt");
    }


    @Override
    public long solvePartOne() {
        int count = 0;
        for(String s : values) {
            String[] inputParts = s.split(" \\| ");
            String[] numbers = inputParts[1].split(" ");
            for(String n : numbers) {
                if (n.length() == 2 || n.length() == 4 || n.length() == 3 || n.length() == 7) {
                    count++;
                }
            }
        }
        System.out.println("The number of times a 1, 4, 7 or 8 is present on the output display is " + count);
        return count;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
