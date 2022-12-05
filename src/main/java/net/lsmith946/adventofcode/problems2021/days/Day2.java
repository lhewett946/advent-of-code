package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.CompassDirections;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Day2 implements Puzzle<Long> {

    private List<String> values;

    public Day2() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day2_input.txt");
    }


    private CompassDirections decodeDirections(String direction) {
        return switch(direction) {
            case "forward" -> CompassDirections.EAST;
            case "up" -> CompassDirections.SOUTH; // up is south because up decreases depth, and down (the default) will increase it
            default -> CompassDirections.NORTH;
        };
    }

    @Override
    public Long solvePartOne() {
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
    public Long solvePartTwo() {
        Grid2DCoordinates currentPosition = new Grid2DCoordinates(0, 0);
        int aim = 0;
        for(String s : values) {
            String[] splitString = s.split(" ");
            CompassDirections direction = decodeDirections(splitString[0]);
            int magnitude = Integer.parseInt(splitString[1]);

            // moving forward increases your depth by some value, depending on your aim
            // moving up or down changes your aim
            if (Objects.equals(splitString[0], "forward")) {
                int depthChange = aim * magnitude;
                currentPosition = currentPosition.move(direction, magnitude);
                currentPosition = currentPosition.move(CompassDirections.NORTH, depthChange);
            } else {
                if (Objects.equals(splitString[0], "up")) {
                    aim -= magnitude;
                } else {
                    aim += magnitude;
                }
            }
        }
        System.out.println("Current position is " + currentPosition.toString());
        long product = (long) currentPosition.getX() * currentPosition.getY();
        System.out.println("The product is " + product);
        return product;
    }
}
