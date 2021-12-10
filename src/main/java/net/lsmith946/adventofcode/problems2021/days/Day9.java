package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day9 implements Puzzle {

    private int[][] values;

    public Day9() throws IOException {
        this.values = InputLoader.loadTo2DIntArray("/2021/day9_input.txt");
    }

    private boolean isLowPoint(int row, int column) {
        int rows = values.length;
        int columns = values[0].length;
        boolean lowPoint = true;
        if (row-1 >= 0) {
            if (values[row][column] >= values[row-1][column]) {
                lowPoint = false;
            }
        }
        if (row+1 < rows) {
            if (values[row][column] >= values[row+1][column]) {
                lowPoint = false;
            }
        }
        if (column-1 >= 0) {
            if (values[row][column] >= values[row][column - 1]) {
                lowPoint = false;
            }
        }
        if (column+1 < columns) {
            if (values[row][column] >= values[row][column+1]) {
                lowPoint = false;
            }
        }
        return lowPoint;
    }

    @Override
    public long solvePartOne() {
        int riskSum = 0;
        int rows = values.length;
        int columns = values[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if (isLowPoint(r, c)) {
                    riskSum += values[r][c] + 1;
                }
            }
        }
        System.out.println("The total of the risk level of all the low points is " + riskSum);
        return riskSum;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
