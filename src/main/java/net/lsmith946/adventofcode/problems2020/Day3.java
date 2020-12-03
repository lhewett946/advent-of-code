package net.lsmith946.adventofcode.problems2020;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day3 implements Puzzle {

    List<String> values;

    public Day3() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day3_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 3 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        int currentHorizontalPosition = 0;
        int treesHit = 0;
        for (String s: values) {
            char [] chars = s.toCharArray();
            if (chars[currentHorizontalPosition] == '#')
                treesHit++;
           currentHorizontalPosition += 3;
           if (currentHorizontalPosition >= chars.length)
               currentHorizontalPosition %= chars.length;
        }
        System.out.println("NUmber of trees hit: " + treesHit);
        return treesHit;
    }

    @Override
    public int solvePartTwo() {
        return 0;
    }
}
