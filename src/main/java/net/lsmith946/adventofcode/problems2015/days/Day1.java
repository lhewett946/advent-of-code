package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day1 implements Puzzle {

    String input;

    public Day1() throws IOException {
        InputLoader il = new InputLoader();
        this.input = il.loadToString("/2015/day1_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 1 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        char[] inputAsChars = input.toCharArray();
        int currentFloor = 0;
        for (Character c: inputAsChars) {
            if (c.equals('(')) {
                currentFloor++;
            } else {
                currentFloor--;
            }
        }
        System.out.println("Santa is taken to floor: " + currentFloor);
        return currentFloor;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
