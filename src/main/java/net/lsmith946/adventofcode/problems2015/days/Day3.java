package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Santa;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public class Day3 implements Puzzle<Integer> {

    char[] input;

    public Day3() throws IOException, URISyntaxException, InterruptedException {
        this.input = InputLoader.loadToCharArray(2015, 3);
    }

    @Override
    public Integer solvePartOne() {
        Santa santa = new Santa();
        for(char c : input) {
            santa.addHouseLocation(c);
        }
        System.out.println("Santa has visited " + santa.getHousesVisited().size() + " houses.");
        return santa.getHousesVisited().size();
    }

    @Override
    public Integer solvePartTwo() {
        Santa santa = new Santa();
        Santa roboSanta = new Santa();
        for(int i = 0; i < input.length/2; i++) {
            santa.addHouseLocation(input[i*2]);
            roboSanta.addHouseLocation(input[(i*2)+1]);
        }
        Set<Grid2DCoordinates> visitedHouses = santa.getHousesVisited();
        visitedHouses.addAll(roboSanta.getHousesVisited());
        System.out.println("Between them, Santa and Robo-Santa have visited " + visitedHouses.size() + " houses.");
        return visitedHouses.size();
    }
}
