package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class Day11 implements Puzzle<Long> {

    char[][] values;
    List<Grid2DCoordinates> galaxyLocations;
    List<Integer> rowsWithoutGalaxies;
    List<Integer> columnsWithoutGalaxies;

    public Day11()throws IOException,URISyntaxException,InterruptedException {
        this.values = InputLoader.loadTo2DCharArray(2023, 11);
        galaxyLocations = new ArrayList<>();
        rowsWithoutGalaxies = new ArrayList<>();
        columnsWithoutGalaxies = new ArrayList<>();
        findGalaxies();
        findExpandableSpace();
    }

    private void findGalaxies() {
        for(int x = 0; x < values.length; x++) {
            for(int y = 0; y < values[x].length; y++) {
                if (values[x][y] == '#') {
                    Grid2DCoordinates newGalaxy = new Grid2DCoordinates(x, y);
                    galaxyLocations.add(newGalaxy);
                }
            }
        }
    }

    private void findExpandableSpace() {
        for(int row = 0; row < values.length; row++) {
            boolean containsGalaxy = false;
            for(int column = 0; column < values[row].length; column++) {
                if (values[row][column] == '#') {
                    containsGalaxy = true;
                    break;
                }
            }
            if (!containsGalaxy) {
                rowsWithoutGalaxies.add(row);
            }
        }

        for(int column = 0; column < values[0].length; column++) {
            boolean containsGalaxy = false;
            for(int row = 0; row < values.length; row++) {
                if (values[row][column] == '#') {
                    containsGalaxy = true;
                    break;
                }
            }
            if (!containsGalaxy) {
                columnsWithoutGalaxies.add(column);
            }
        }
    }

    @Override
    public Long solvePartOne() {
        long totalDistance = 0L;
        for(int i = 0; i < galaxyLocations.size(); i++) {
            for(int j = i+1; j < galaxyLocations.size(); j++) {
                totalDistance += galaxyLocations.get(i).getManhattanDistanceTo(galaxyLocations.get(j));

                // account for expansion
                int lowestRow = Math.min(galaxyLocations.get(i).getX(), galaxyLocations.get(j).getX());
                int highestRow = Math.max(galaxyLocations.get(i).getX(), galaxyLocations.get(j).getX());

                for(int row = lowestRow; row <= highestRow; row++) {
                    if (rowsWithoutGalaxies.contains(row)) {
                        totalDistance++; // add another one to the total distance to account for the expansion
                    }
                }

                int lowestColumn = Math.min(galaxyLocations.get(i).getY(), galaxyLocations.get(j).getY());
                int highestColumn = Math.max(galaxyLocations.get(i).getY(), galaxyLocations.get(j).getY());

                for(int column = lowestColumn; column <= highestColumn; column++) {
                    if (columnsWithoutGalaxies.contains(column)) {
                        totalDistance++; // add another one to the total distance to account for the expansion
                    }
                }
            }
        }
        System.out.println("The total distance between all the pairs of galaxies is " + totalDistance);
        return totalDistance;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
