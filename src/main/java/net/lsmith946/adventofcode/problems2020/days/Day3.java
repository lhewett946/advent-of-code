package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day3 implements Puzzle<Long> {

    List<String> values;

    public Day3() throws IOException {
        this.values = InputLoader.loadToStringList("/2020/day3_input.txt");
    }

    private int countTreesOnRoute(int horizontalChange, int verticalChange) {
        int currentHorizontalPosition = 0;
        int currentVerticalPosition = 0;
        int treesHit = 0;
        while(currentVerticalPosition < values.toArray().length) {
            char [] chars = values.get(currentVerticalPosition).toCharArray();
            if (chars[currentHorizontalPosition] == '#')
                treesHit++;
            currentHorizontalPosition += horizontalChange;
            if (currentHorizontalPosition >= chars.length)
                currentHorizontalPosition %= chars.length;
            currentVerticalPosition += verticalChange;
        }
        return treesHit;
    }

    @Override
    public Long solvePartOne() {
        int treesHit = countTreesOnRoute(3, 1);
        System.out.println("Number of trees hit: " + treesHit);
        return (long) treesHit;
    }

    @Override
    public Long solvePartTwo() {
        long product = 1;
        product *= countTreesOnRoute(1, 1);
        product *= countTreesOnRoute(3, 1);
        product *= countTreesOnRoute(5, 1);
        product *= countTreesOnRoute(7, 1);
        product *= countTreesOnRoute(1, 2);
        System.out.println("Product of trees hit on each route: " + product);
        return product;
    }
}
