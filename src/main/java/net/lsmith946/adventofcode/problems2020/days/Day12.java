package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day12 implements Puzzle<Integer> {

    List<String> directions;

    public Day12() throws IOException {
        directions = InputLoader.loadToStringList("/2020/day12_input.txt");
    }

    private CompassDirection turnLeft(CompassDirection currentDirection, int degrees) {
        for (int turnsMade = 0; turnsMade < degrees / 90; turnsMade++) {
            switch (currentDirection) {
                case EAST -> currentDirection = CompassDirection.NORTH;
                case WEST -> currentDirection = CompassDirection.SOUTH;
                case NORTH -> currentDirection = CompassDirection.WEST;
                case SOUTH -> currentDirection = CompassDirection.EAST;
            }
        }
        return currentDirection;
    }

    private CompassDirection turnRight(CompassDirection currentDirection, int degrees) {
        for (int turnsMade = 0; turnsMade < degrees / 90; turnsMade++) {
            switch (currentDirection) {
                case EAST -> currentDirection = CompassDirection.SOUTH;
                case WEST -> currentDirection = CompassDirection.NORTH;
                case NORTH -> currentDirection = CompassDirection.EAST;
                case SOUTH -> currentDirection = CompassDirection.WEST;
            }
        }
        return currentDirection;
    }

    @Override
    public Integer solvePartOne() {
        CompassDirection currentlyFacing = CompassDirection.EAST;
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
    public Integer solvePartTwo() {
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
