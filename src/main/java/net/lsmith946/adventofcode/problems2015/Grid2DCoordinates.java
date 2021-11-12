package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.utils.CompassDirections;

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
        switch(direction) {
            case NORTH -> y++;
            case SOUTH -> y--;
            case EAST -> x++;
            case WEST -> x--;
        }
        return new Grid2DCoordinates(x, y);
    }
}
