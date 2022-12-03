package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day9 implements Puzzle {

    private int[][] values;

    public Day9() throws IOException {
        this.values = InputLoader.loadTo2DIntArray("/2021/day9_input.txt");
    }

    private boolean isLowPoint(Grid2DCoordinates location) {
        int rows = values.length;
        int columns = values[0].length;
        boolean lowPoint = true;
        if (location.getX()-1 >= 0) {
            if (values[location.getX()][location.getY()] >= values[location.getX()-1][location.getY()]) {
                lowPoint = false;
            }
        }
        if (location.getX()+1 < rows) {
            if (values[location.getX()][location.getY()] >= values[location.getX()+1][location.getY()]) {
                lowPoint = false;
            }
        }
        if (location.getY()-1 >= 0) {
            if (values[location.getX()][location.getY()] >= values[location.getX()][location.getY() - 1]) {
                lowPoint = false;
            }
        }
        if (location.getY()+1 < columns) {
            if (values[location.getX()][location.getY()] >= values[location.getX()][location.getY()+1]) {
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
                if (isLowPoint(new Grid2DCoordinates(r, c))) {
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
