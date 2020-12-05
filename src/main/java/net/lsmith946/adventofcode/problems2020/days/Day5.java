package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day5 implements Puzzle {

    List<String> values;

    public Day5() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day5_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 5 ------");
        solvePartOne();
        solvePartTwo();
    }

    private int calculateSeatID(String s) {
        int row;
        int column;
        s = s.replace("F", "0")
            .replace("B", "1")
            .replace("L", "0")
            .replace("R", "1");

        row = Integer.parseInt(s.substring(0, 7), 2);
        column = Integer.parseInt(s.substring(7, 10), 2);
        return ((row*8) + column);
    }

    @Override
    public int solvePartOne() {
        int highestSeatID = 0;
        for (String s: values) {
            highestSeatID = Math.max(highestSeatID, calculateSeatID(s));
        }
        System.out.println("The highest seat ID is: " + highestSeatID);
        return highestSeatID;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
