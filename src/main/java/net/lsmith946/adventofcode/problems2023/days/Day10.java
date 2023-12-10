package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.LoopTraveller;
import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class Day10 implements Puzzle<Long> {

    char[][] values;

    public Day10() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadTo2DCharArray(2023, 10);
    }

    private Grid2DCoordinates findStartingPoint() {
        Grid2DCoordinates startingPoint = null;
        for(int y = 0; y < values.length; y++) {
            for(int x = 0; x < values.length; x++) {
                if (values[y][x] == 'S') {
                    startingPoint = new Grid2DCoordinates(x, y);
                }
            }
        }

        // check that the starting point was found
        if (startingPoint == null) {
            throw new IllegalStateException("Unable to locate the starting point!");
        }
        return startingPoint;
    }

    // find the pipes that are connected to the start point
    // there must be exactly two of them, so check this to avoid errors
    // create a loop traverser at each point to
    private List<LoopTraveller> findConnectedPipes(Grid2DCoordinates startPoint) {
        List<Grid2DCoordinates> adjacentPoints = startPoint.getAdjacentCoords(false);
        List<LoopTraveller> loopTravellers = new ArrayList<>();
        for(Grid2DCoordinates point : adjacentPoints) {
            switch (values[point.getY()][point.getX()]) {
                case '|' -> {
                    if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                        loopTravellers.add(loopTraveller);
                    }
                }
                case '-' -> {
                    if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                        loopTravellers.add(loopTraveller);
                    }
                }
                case 'L' -> {
                    if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                        loopTravellers.add(loopTraveller);
                    }
                }
                case 'J' -> {
                    if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                        loopTravellers.add(loopTraveller);
                    }
                }
                case '7' -> {
                    if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                        loopTravellers.add(loopTraveller);
                    }
                }
                case 'F' -> {
                    if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                        loopTravellers.add(loopTraveller);
                    }
                    else if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                        LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                        loopTravellers.add(loopTraveller);
                    }
                }
            }
        }
        if (loopTravellers.size() != 2) {
            throw new IllegalStateException("Found more than 2 points connected to the start point");
        }
        return loopTravellers;
    }

    @Override
    public Long solvePartOne() {
        // start by finding the start point, S
        Grid2DCoordinates startingPoint = null;
        for(int y = 0; y < values.length; y++) {
            for(int x = 0; x < values.length; x++) {
                if (values[y][x] == 'S') {
                    startingPoint = new Grid2DCoordinates(x, y);
                }
            }
        }

        // check that the starting point was found
        if (startingPoint == null) {
            throw new IllegalStateException("Unable to locate the starting point!");
        }

        List<LoopTraveller> startingPointConnections = findConnectedPipes(startingPoint);
        long steps = 1;
        LoopTraveller traveller1 = startingPointConnections.get(0);
        LoopTraveller traveller2 = startingPointConnections.get(1);

        while(!traveller1.getCurrentPosition().equals(traveller2.getCurrentPosition())) {
            traveller1.move(values[traveller1.getCurrentPosition().getY()][traveller1.getCurrentPosition().getX()]);
            traveller2.move(values[traveller2.getCurrentPosition().getY()][traveller2.getCurrentPosition().getX()]);
            steps++;
        }
        System.out.println("The farthest point in terms of steps along the loop is " + steps + " steps away");
        return steps;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
