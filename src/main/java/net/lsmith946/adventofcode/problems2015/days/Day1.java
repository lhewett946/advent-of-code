package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day1 implements Puzzle {

    char[] input;

    public Day1() throws IOException {
        InputLoader il = new InputLoader();
        this.input = il.loadToCharArray("/2015/day1_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 1 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int currentFloor = 0;
        for (Character c : input) {
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
        int currentFloor = 0;
        for (int pos = 0; pos < input.length; pos++) {
            if (input[pos] == '(') {
                currentFloor++;
            } else {
                currentFloor--;
            }
            if (currentFloor == -1) {
                System.out.println("Santa is taken to the basement by the character at position: " + (pos + 1));
                return pos + 1;
            }
        }
        return -1;
    }
}
