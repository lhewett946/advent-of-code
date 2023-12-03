package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Day3 implements Puzzle<Long> {

    char [][] values;

    public Day3() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadTo2DCharArray(2023, 3);
    }

    @Override
    public Long solvePartOne() {
        long sum = 0L;
        for(int row = 0; row < values.length; row++) {
            long currentPartNumber = 0;
            Set<Grid2DCoordinates> adjacentPositions = new HashSet<>();
            for (int column = 0; column < values[0].length; column++) {
                Grid2DCoordinates currentPosition = new Grid2DCoordinates(row, column);
                if (((Character) values[currentPosition.getX()][currentPosition.getY()]).toString().matches("[0-9]")) {
                    currentPartNumber = (10 * currentPartNumber) + Long.parseLong(String.valueOf(values[currentPosition.getX()][currentPosition.getY()]));
                    adjacentPositions.addAll(currentPosition.getAdjacentCoords(true));
                }

                if (((Character) values[currentPosition.getX()][currentPosition.getY()]).toString().matches("[^0-9]") || column == values[0].length - 1) {
                    boolean hasAdjacentSymbol = false;
                    for (Grid2DCoordinates coord : adjacentPositions) {
                        if (coord.hasInRangeCoords(0, values.length - 1, 0, values[0].length - 1)) {
                            if (((Character) values[coord.getX()][coord.getY()]).toString().matches("[^0-9.]")) {
                                hasAdjacentSymbol = true;
                            }
                        }
                    }

                    if (hasAdjacentSymbol) {
                        sum += currentPartNumber;
                    }
                    currentPartNumber = 0;
                    adjacentPositions.clear();
                }
            }
        }
        System.out.println("The sum of all the part numbers is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
