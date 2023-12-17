package net.lsmith946.adventofcode.problems2023;

import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;

public class LoopTraveller {

    private Grid2DCoordinates currentPosition;
    private CompassDirection lastMoveDirection;

    public Grid2DCoordinates getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Grid2DCoordinates currentPosition) {
        this.currentPosition = currentPosition;
    }

    public CompassDirection getLastMoveDirection() {
        return lastMoveDirection;
    }

    public LoopTraveller(Grid2DCoordinates currentPosition, CompassDirection lastMoveDirection) {
        this.currentPosition = currentPosition;
        this.lastMoveDirection = lastMoveDirection;
    }

    private CompassDirection findNextDirection(char pipeType) {
        switch (pipeType) {
            case '|' -> {
                if (lastMoveDirection == CompassDirection.NORTH) {
                    return CompassDirection.NORTH;
                } else if (lastMoveDirection == CompassDirection.SOUTH) {
                    return CompassDirection.SOUTH;
                }
            }
            case '-' -> {
                if (lastMoveDirection == CompassDirection.EAST) {
                    return CompassDirection.EAST;
                } else if (lastMoveDirection == CompassDirection.WEST) {
                    return CompassDirection.WEST;
                }
            }
            case 'L' -> {
                if (lastMoveDirection == CompassDirection.SOUTH) {
                    return CompassDirection.EAST;
                } else if (lastMoveDirection == CompassDirection.WEST) {
                    return CompassDirection.NORTH;
                }
            }
            case 'J' -> {
                if (lastMoveDirection == CompassDirection.SOUTH) {
                    return CompassDirection.WEST;
                } else if (lastMoveDirection == CompassDirection.EAST) {
                    return CompassDirection.NORTH;
                }
            }
            case '7' -> {
                if (lastMoveDirection == CompassDirection.NORTH) {
                    return CompassDirection.WEST;
                } else if (lastMoveDirection == CompassDirection.EAST) {
                    return CompassDirection.SOUTH;
                }
            }
            case 'F' -> {
                if (lastMoveDirection == CompassDirection.NORTH) {
                    return CompassDirection.EAST;
                } else if (lastMoveDirection == CompassDirection.WEST) {
                    return CompassDirection.SOUTH;
                }
            }
        }
        throw new IllegalStateException("Unable to determine the next move");
    }

    public void move(char pipeType) {
        CompassDirection direction = findNextDirection(pipeType);
        currentPosition = currentPosition.move(direction, 1);
        lastMoveDirection = direction;
    }
}
