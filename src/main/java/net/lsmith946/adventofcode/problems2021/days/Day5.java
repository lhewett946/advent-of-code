package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.CompassDirections;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day5 implements Puzzle {

    private List<String> values;

    public Day5() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day5_input.txt");
    }

    private Grid2DCoordinates[] parseCoordinates (String str) {
        Grid2DCoordinates[] startEndPoints = new Grid2DCoordinates[2];
        String[] coordinates = str.split(" -> ");
        String[] startCoordinate = coordinates[0].split(",");
        startEndPoints[0] = new Grid2DCoordinates(Integer.parseInt(startCoordinate[0]), Integer.parseInt(startCoordinate[1]));
        String[] endCoordinate = coordinates[1].split(",");
        startEndPoints[1] = new Grid2DCoordinates(Integer.parseInt(endCoordinate[0]), Integer.parseInt(endCoordinate[1]));
        return startEndPoints;
    }

    private Set<Grid2DCoordinates> listIntermediateCoordinates(Grid2DCoordinates startPoint, Grid2DCoordinates endPoint) {
        Grid2DCoordinates currentPosition = startPoint;
        Set<Grid2DCoordinates> intermediatePoints = new HashSet<>();
        intermediatePoints.add(startPoint);
        while(!currentPosition.equals(endPoint)) {
            if (currentPosition.getX() < endPoint.getX()) {
                currentPosition = currentPosition.move(CompassDirections.EAST, 1);
            } else if (currentPosition.getX() > endPoint.getX()) {
                currentPosition = currentPosition.move(CompassDirections.WEST, 1);
            }

            if (currentPosition.getY() < endPoint.getY()) {
                currentPosition = currentPosition.move(CompassDirections.NORTH, 1);
            } else if (currentPosition.getY() > endPoint.getY()) {
                currentPosition = currentPosition.move(CompassDirections.SOUTH, 1);
            }
            intermediatePoints.add(currentPosition);
        }
        return intermediatePoints;
    }

    @Override
    public long solvePartOne() {
        Map<Grid2DCoordinates, Integer> pointsCrossedCount = new HashMap<>();
        for(String s : values) {
            Grid2DCoordinates[] startEndPoints = parseCoordinates(s);
            // process line only if horizontal or vertical
            if (startEndPoints[0].getX() == startEndPoints[1].getX() ||
                startEndPoints[0].getY() == startEndPoints[1].getY()) {
                Set<Grid2DCoordinates> coordinatesCovered = listIntermediateCoordinates(startEndPoints[0], startEndPoints[1]);
                for(Grid2DCoordinates pos : coordinatesCovered) {
                    if (pointsCrossedCount.containsKey(pos)) {
                        int currentCountAtPos = pointsCrossedCount.get(pos);
                        currentCountAtPos++;
                        pointsCrossedCount.replace(pos, currentCountAtPos);
                    } else {
                        pointsCrossedCount.put(pos, 1);
                    }
                }
            }
        }
        // after processing all lines, determine how many points have at least 2 lines crossing them
        int count = 0;
        for(Grid2DCoordinates pos : pointsCrossedCount.keySet()) {
            if (pointsCrossedCount.get(pos) >= 2) {
                count++;
            }
        }
        System.out.println("The number of points where two or more lines cross is " + count);
        return count;
    }

    @Override
    public long solvePartTwo() {
        Map<Grid2DCoordinates, Integer> pointsCrossedCount = new HashMap<>();
        for(String s : values) {
            Grid2DCoordinates[] startEndPoints = parseCoordinates(s);
            Set<Grid2DCoordinates> coordinatesCovered = listIntermediateCoordinates(startEndPoints[0], startEndPoints[1]);
            for(Grid2DCoordinates pos : coordinatesCovered) {
                if (pointsCrossedCount.containsKey(pos)) {
                    int currentCountAtPos = pointsCrossedCount.get(pos);
                    currentCountAtPos++;
                    pointsCrossedCount.replace(pos, currentCountAtPos);
                } else {
                    pointsCrossedCount.put(pos, 1);
                }
            }
        }

        // after processing all lines, determine how many points have at least 2 lines crossing them
        int count = 0;
        for(Grid2DCoordinates pos : pointsCrossedCount.keySet()) {
            if (pointsCrossedCount.get(pos) >= 2) {
                count++;
            }
        }
        System.out.println("The number of points where two or more lines cross is " + count);
        return count;
    }
}
