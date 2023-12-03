package net.lsmith946.adventofcode.utils;

import java.util.ArrayList;
import java.util.List;
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

    public Grid2DCoordinates move(CompassDirection direction, int magnitude) {
        Grid2DCoordinates newPosition = new Grid2DCoordinates(x, y);
        switch(direction) {
            case NORTH -> newPosition.y += magnitude;
            case SOUTH -> newPosition.y -= magnitude;
            case EAST -> newPosition.x += magnitude;
            case WEST -> newPosition.x -= magnitude;
        }
        return newPosition;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Grid2DCoordinates> getAdjacentCoords(boolean includeDiagonals) {
        List<Grid2DCoordinates> coords = new ArrayList<>();
        coords.add(new Grid2DCoordinates(x, y-1));
        coords.add(new Grid2DCoordinates(x, y+1));
        coords.add(new Grid2DCoordinates(x+1, y));
        coords.add(new Grid2DCoordinates(x-1, y));
        if (includeDiagonals) {
            coords.add(new Grid2DCoordinates(x-1, y-1));
            coords.add(new Grid2DCoordinates(x-1, y+1));
            coords.add(new Grid2DCoordinates(x+1, y-1));
            coords.add(new Grid2DCoordinates(x+1, y+1));
        }
        return coords;
    }

    public boolean hasInRangeCoords(int xMin, int xMax, int yMin, int yMax) {
        return (x >= xMin && x <= xMax && y >= yMin && y <= yMax);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
