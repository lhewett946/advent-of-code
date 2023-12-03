package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

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
        long sum = 0L;
        for(int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[0].length; column++) {
                Grid2DCoordinates currentPosition = new Grid2DCoordinates(row, column);
                if (((Character) values[currentPosition.getX()][currentPosition.getY()]).toString().matches("\\*")) {
                    List<Long> adjacentPartNumbers = new ArrayList<>();
                    List<Grid2DCoordinates> adjacentPositions = currentPosition.getAdjacentCoords(true);
                    while(!adjacentPositions.isEmpty()) {
                        Grid2DCoordinates testPosition = adjacentPositions.get(0);
                        if (((Character) values[testPosition.getX()][testPosition.getY()]).toString().matches("[0-9]")) {
                            long partNumber = Long.parseLong(String.valueOf(values[testPosition.getX()][testPosition.getY()]));
                            // if we find a number, first iterate to the left looking for more significant digits
                            // if we find any, remove them from the adjacent positions list if they are in there
                            Grid2DCoordinates leftOfTestPosition = new Grid2DCoordinates(testPosition.getX(), testPosition.getY()-1);
                            while((((Character) values[leftOfTestPosition.getX()][leftOfTestPosition.getY()]).toString().matches("[0-9]"))) {
                                long valueToShift = Long.parseLong(String.valueOf(values[leftOfTestPosition.getX()][leftOfTestPosition.getY()]));
                                for(int i = 0; i < (testPosition.getY() - leftOfTestPosition.getY()); i++) {
                                    valueToShift = 10 * valueToShift;
                                }
                                partNumber += valueToShift;
                                adjacentPositions.remove(leftOfTestPosition);
                                leftOfTestPosition = new Grid2DCoordinates(leftOfTestPosition.getX(), leftOfTestPosition.getY()-1);
                                if  (!leftOfTestPosition.hasInRangeCoords(0, values.length-1, 0, values[0].length-1))
                                    break;
                            }

                            // if we find a number, next iterate to the right looking for less significant digits
                            // if we find any, remove them from the adjacent positions list if they are in there
                            Grid2DCoordinates rightOfTestPosition = new Grid2DCoordinates(testPosition.getX(), testPosition.getY()+1);
                            while((((Character) values[rightOfTestPosition.getX()][rightOfTestPosition.getY()]).toString().matches("[0-9]"))) {
                                partNumber = (partNumber * 10) + Long.parseLong(String.valueOf(values[rightOfTestPosition.getX()][rightOfTestPosition.getY()]));
                                adjacentPositions.remove(rightOfTestPosition);
                                rightOfTestPosition = new Grid2DCoordinates(rightOfTestPosition.getX(), rightOfTestPosition.getY()+1);
                                if  (!rightOfTestPosition.hasInRangeCoords(0, values.length-1, 0, values[0].length-1))
                                    break;
                            }

                            adjacentPartNumbers.add(partNumber);
                        }
                        adjacentPositions.remove(0);
                }

                    if (adjacentPartNumbers.size() == 2) {
                        sum += (adjacentPartNumbers.get(0) * adjacentPartNumbers.get(1));
                    }
                }
            }
        }
        System.out.println("The sum of all the gear ratios is " + sum);
        return sum;
    }
}
