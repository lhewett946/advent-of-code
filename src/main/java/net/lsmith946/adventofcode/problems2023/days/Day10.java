package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.LoopTraveller;
import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Day10 implements Puzzle<Long> {

    char[][] values;

    public Day10() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadTo2DCharArray(2023, 10);
    }

    private Grid2DCoordinates findStartingPoint(char[][] map) {
        Grid2DCoordinates startingPoint = null;
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 'S') {
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
    // create a loop traveller each point to go around the loop in opposite directions until the entire loop is mapped out
    private List<LoopTraveller> findConnectedPipes(Grid2DCoordinates startPoint, char[][] map) {
        List<Grid2DCoordinates> adjacentPoints = startPoint.getAdjacentCoords(false);
        List<LoopTraveller> loopTravellers = new ArrayList<>();
        for(Grid2DCoordinates point : adjacentPoints) {
            if (point.hasInRangeCoords(0, map[0].length - 1, 0, map.length - 1)) {
                switch (map[point.getY()][point.getX()]) {
                    case '|' -> {
                        if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                            loopTravellers.add(loopTraveller);
                        }
                    }
                    case '-' -> {
                        if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                            loopTravellers.add(loopTraveller);
                        }
                    }
                    case 'L' -> {
                        if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                            loopTravellers.add(loopTraveller);
                        }
                    }
                    case 'J' -> {
                        if (point.move(CompassDirection.NORTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.SOUTH);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                            loopTravellers.add(loopTraveller);
                        }
                    }
                    case '7' -> {
                        if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.WEST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.EAST);
                            loopTravellers.add(loopTraveller);
                        }
                    }
                    case 'F' -> {
                        if (point.move(CompassDirection.SOUTH, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.NORTH);
                            loopTravellers.add(loopTraveller);
                        } else if (point.move(CompassDirection.EAST, 1).equals(startPoint)) {
                            LoopTraveller loopTraveller = new LoopTraveller(point, CompassDirection.WEST);
                            loopTravellers.add(loopTraveller);
                        }
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
        Grid2DCoordinates startingPoint = findStartingPoint(this.values);

        List<LoopTraveller> startingPointConnections = findConnectedPipes(startingPoint, this.values);
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

    private char[][] expandMap() {
        // insert an extra column after each column and an extra row after each row
        // extra columns will entirely contain '-' to ensure they continue any connection
        // extra rows will entirely contain '|' to ensure they continue any connection
        // it doesn't really matter what positions that are part of both an extra row and an extra column contain
        char[][] expanded = new char[values.length*2][values[0].length*2];

        for(int y = 0; y < expanded.length; y++) {
            for(int x = 0; x < expanded[y].length; x++) {
                // if both the row and the column are even then take the character from the original map
                if ((x%2 == 0) && (y%2 == 0)) {
                    expanded[y][x] = values[y/2][x/2];
                }
                // if only the row is even, we must be in a new column so insert a -
                else if (y%2 == 0) {
                    expanded[y][x] = '-';
                }
                // otherwise, add a | to continue any connection across this new romw
                else {
                    expanded[y][x] = '|';
                }
            }
        }
        return expanded;
    }

    private char[][] floodFillMap(char[][] map) {
        List<Grid2DCoordinates> fillCoords = new ArrayList<>();
        // create a line of fill points around the sides of the grid
        // to expand in from each side
        // left and right sides
        for(int y = 0; y < map.length; y++) {
            fillCoords.add(new Grid2DCoordinates(-1,y));
            fillCoords.add(new Grid2DCoordinates(map[y].length,y));
        }

        // top and bottom sides
        for(int x = 0; x < map[0].length; x++) {
            fillCoords.add(new Grid2DCoordinates(x,-1));
            fillCoords.add(new Grid2DCoordinates(x, map.length));
        }

        while(!fillCoords.isEmpty()) {
            Grid2DCoordinates fillPoint = fillCoords.remove(0);
            List<Grid2DCoordinates> adjacentPoints = fillPoint.getAdjacentCoords(false);
            for(Grid2DCoordinates point : adjacentPoints) {
                if (point.hasInRangeCoords(0, map[0].length-1, 0, map.length-1)) {
                    if (map[point.getY()][point.getX()] != 'S' && map[point.getY()][point.getX()] != 'O' && !fillCoords.contains(point)) {
                        fillCoords.add(point);
                    }
                }
            }
            if (fillPoint.hasInRangeCoords(0, map[0].length-1, 0, map.length-1)) {
                map[fillPoint.getY()][fillPoint.getX()] = 'O';
            }
        }

        return map;
    }

    @Override
    public Long solvePartTwo() {
        // expand the map to ensure any gap between the pipes always has a width of one and can be found without
        // having to use doubles
        char[][] expandedMap = expandMap();

        // find and map out the loop in this new, expanded map
        Grid2DCoordinates startingPoint = findStartingPoint(this.values);
        List<LoopTraveller> startingPointConnections = findConnectedPipes(startingPoint, this.values);
        LoopTraveller traveller1 = startingPointConnections.get(0);
        // scale the starting location of the traveller up to the expanded map
        Grid2DCoordinates travellerStart = new Grid2DCoordinates(traveller1.getCurrentPosition().getX()*2, traveller1.getCurrentPosition().getY()*2);
        traveller1.setCurrentPosition(travellerStart);
        // mark off the expansion that has been applied to the start location as outside the loop
        if (traveller1.getLastMoveDirection() == CompassDirection.EAST) {
            // if the move was in the horizontal direction, change the X value
            expandedMap[(startingPoint.getY()*2)][(startingPoint.getX()*2)+1] = 'S';
        }
        else if (traveller1.getLastMoveDirection() == CompassDirection.WEST) {
            // if the move was in the horizontal direction, change the X value
            expandedMap[(startingPoint.getY()*2)][(startingPoint.getX()*2)-1] = 'S';
        }
        else if (traveller1.getLastMoveDirection() == CompassDirection.NORTH) {
            // if the move was in the vertical direction, change the Y value
            expandedMap[(startingPoint.getY()*2)-1][(startingPoint.getX()*2)] = 'S';
        }
        else {
            // if the move was in the vertical direction, change the Y value
            expandedMap[(startingPoint.getY()*2)+1][(startingPoint.getX()*2)] = 'S';
        }

        while(expandedMap[traveller1.getCurrentPosition().getY()][traveller1.getCurrentPosition().getX()] != 'S') {
            char pipeType = expandedMap[traveller1.getCurrentPosition().getY()][traveller1.getCurrentPosition().getX()];
            expandedMap[traveller1.getCurrentPosition().getY()][traveller1.getCurrentPosition().getX()] = 'S';
            traveller1.move(pipeType);
        }

        expandedMap = floodFillMap(expandedMap);

        // count up all the characters that are not O or S, to find the characters inside the loop
        // jump by 2 each step to exclude the added rows and columns
        long count = 0;
        for(int y = 0; y < expandedMap.length; y += 2) {
            for(int x = 0; x < expandedMap[y].length; x += 2) {
                if (expandedMap[y][x] != 'O' && expandedMap[y][x] != 'S') {
                    count++;
                }
            }
        }
        System.out.println("The area to search for the nest is " + count);
        return count;
    }
}
