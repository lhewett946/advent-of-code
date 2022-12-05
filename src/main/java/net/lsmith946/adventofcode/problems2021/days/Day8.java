package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day8 implements Puzzle<Integer> {

    private List<String> values;

    public Day8() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day8_input.txt");
    }


    @Override
    public Integer solvePartOne() {
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
    public Integer solvePartTwo() {
        return 0;
    }
}
