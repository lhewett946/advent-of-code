package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.CompassDirections;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day2 implements Puzzle {

    private List<String> values;

    public Day2() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day2_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 2 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    private CompassDirections decodeDirections(String direction) {
        return switch(direction) {
            case "forward" -> CompassDirections.EAST;
            case "up" -> CompassDirections.SOUTH; // up is south because up decreases depth, and down (teh default) will increase it
            default -> CompassDirections.NORTH;
        };
    }

    @Override
    public long solvePartOne() {
        Grid2DCoordinates currentPosition = new Grid2DCoordinates(0, 0);
        for(String s : values) {
            String[] splitString = s.split(" ");
            CompassDirections direction = decodeDirections(splitString[0]);
            int magnitude = Integer.parseInt(splitString[1]);
            currentPosition = currentPosition.move(direction, magnitude);
        }
        System.out.println("Current position is " + currentPosition.toString());
        long product = (long) currentPosition.getX() * currentPosition.getY();
        System.out.println("The product is " + product);
        return product;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
