package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.CompassDirections;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day12 implements Puzzle {

    List<String> directions;

    public Day12() throws IOException {
        InputLoader il = new InputLoader();
        directions = il.loadToStringList("/2020/day12_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 12 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    private CompassDirections turnLeft(CompassDirections currentDirection, int degrees) {
        for (int turnsMade = 0; turnsMade < degrees / 90; turnsMade++) {
            switch (currentDirection) {
                case EAST -> currentDirection = CompassDirections.NORTH;
                case WEST -> currentDirection = CompassDirections.SOUTH;
                case NORTH -> currentDirection = CompassDirections.WEST;
                case SOUTH -> currentDirection = CompassDirections.EAST;
            }
        }
        return currentDirection;
    }

    private CompassDirections turnRight(CompassDirections currentDirection, int degrees) {
        for (int turnsMade = 0; turnsMade < degrees / 90; turnsMade++) {
            switch (currentDirection) {
                case EAST -> currentDirection = CompassDirections.SOUTH;
                case WEST -> currentDirection = CompassDirections.NORTH;
                case NORTH -> currentDirection = CompassDirections.EAST;
                case SOUTH -> currentDirection = CompassDirections.WEST;
            }
        }
        return currentDirection;
    }

    @Override
    public long solvePartOne() {
        CompassDirections currentlyFacing = CompassDirections.EAST;
        int northSouthPosition = 0, eastWestPosition = 0;
        for (String movement : directions) {
            // decode the movement into a direction and a number of units to move
            char[] movementChars = movement.toCharArray();
            char direction = movementChars[0];
            int unitsToMove = Integer.parseInt(movement.substring(1));
            // decode the direction of the movement
            switch (direction) {
                case 'N' -> northSouthPosition += unitsToMove;
                case 'S' -> northSouthPosition -= unitsToMove;
                case 'E' -> eastWestPosition += unitsToMove;
                case 'W' -> eastWestPosition -= unitsToMove;
                case 'L' -> currentlyFacing = turnLeft(currentlyFacing, unitsToMove);
                case 'R' -> currentlyFacing = turnRight(currentlyFacing, unitsToMove);
                case 'F' -> {
                    switch (currentlyFacing) {
                        case NORTH -> northSouthPosition += unitsToMove;
                        case SOUTH -> northSouthPosition -= unitsToMove;
                        case EAST -> eastWestPosition += unitsToMove;
                        case WEST -> eastWestPosition -= unitsToMove;
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
        int manhattanDistance = Math.abs(northSouthPosition) + Math.abs(eastWestPosition);
        System.out.println("The Manhattan distance from the start position is: " + manhattanDistance);
        return manhattanDistance;
    }


    @Override
    public long solvePartTwo() {
        CompassDirections currentlyFacing = CompassDirections.EAST;
        int waypointNorthSouthPosition = 1, waypointEastWestPosition = 10;
        int shipNorthSouthPosition = 0, shipEastWestPosition = 0;
        for (String movement : directions) {
            // decode the movement into a direction and a number of units to move
            char[] movementChars = movement.toCharArray();
            char direction = movementChars[0];
            int unitsToMove = Integer.parseInt(movement.substring(1));
            // decode the direction of the movement
            switch (direction) {
                case 'N' -> waypointNorthSouthPosition += unitsToMove;
                case 'S' -> waypointNorthSouthPosition -= unitsToMove;
                case 'E' -> waypointEastWestPosition += unitsToMove;
                case 'W' -> waypointEastWestPosition -= unitsToMove;
                case 'L' -> {
                    for (int rotations = 0; rotations < unitsToMove / 90; rotations++) {
                        int tempNorthSouthPosition = waypointEastWestPosition;
                        int tempEastWestPosition = waypointNorthSouthPosition * -1;
                        waypointNorthSouthPosition = tempNorthSouthPosition;
                        waypointEastWestPosition = tempEastWestPosition;
                    }
                }
                case 'R' -> {
                    for (int rotations = 0; rotations < unitsToMove / 90; rotations++) {
                        int tempNorthSouthPosition = waypointEastWestPosition * -1;
                        int tempEastWestPosition = waypointNorthSouthPosition;
                        waypointNorthSouthPosition = tempNorthSouthPosition;
                        waypointEastWestPosition = tempEastWestPosition;
                    }
                }
                case 'F' -> {
                    for (int i = 0; i < unitsToMove; i++) {
                        shipNorthSouthPosition += waypointNorthSouthPosition;
                        shipEastWestPosition += waypointEastWestPosition;
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction);
            }
        }
        int manhattanDistance = Math.abs(shipNorthSouthPosition) + Math.abs(shipEastWestPosition);
        System.out.println("The Manhattan distance from the start position is: " + manhattanDistance);
        return manhattanDistance;
    }
}
