package net.lsmith946.adventofcode.utils;

import java.util.Objects;

public class Grid2DCoordinates {
    private int x;
    private int y;

    public Grid2DCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid2DCoordinates that = (Grid2DCoordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Grid2DCoordinates move(CompassDirections direction) {
        Grid2DCoordinates newPosition = new Grid2DCoordinates(x, y);
        switch(direction) {
            case NORTH -> newPosition.y++;
            case SOUTH -> newPosition.y--;
            case EAST -> newPosition.x++;
            case WEST -> newPosition.x--;
        }
        return newPosition;
    }
}
