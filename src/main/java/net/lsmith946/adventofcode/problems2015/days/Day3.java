package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.CompassDirections;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day3 implements Puzzle {

    char[] input;

    public Day3() throws IOException {
        InputLoader il = new InputLoader();
        this.input = il.loadToCharArray("/2015/day3_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 3 ------");
        solvePartOne();
        solvePartTwo();
    }

    private CompassDirections decodeDirections(char c) {
        return switch (c) {
            case '^' -> CompassDirections.NORTH;
            case 'v' -> CompassDirections.SOUTH;
            case '>' -> CompassDirections.EAST;
            default -> CompassDirections.WEST;
        };
    }

    private Set<Grid2DCoordinates> getVisitedLocations(char[] instructions) {
        Grid2DCoordinates currentPosition = new Grid2DCoordinates(0, 0);
        Set<Grid2DCoordinates> visitedHouses = new HashSet<>();
        visitedHouses.add(new Grid2DCoordinates(0, 0));
        for(char c : input) {
            CompassDirections direction = decodeDirections(c);
            Grid2DCoordinates newPosition = currentPosition.move(direction);
            visitedHouses.add(newPosition);
            currentPosition = newPosition;
        }
        return visitedHouses;
    }

    @Override
    public long solvePartOne() {
        Set<Grid2DCoordinates> visitedHouses = getVisitedLocations(input);
        System.out.println("Santa has visited " + visitedHouses.size() + " houses.");
        return visitedHouses.size();
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
