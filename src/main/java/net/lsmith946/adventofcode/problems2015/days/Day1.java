package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Santa;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day1 implements Puzzle<Integer> {

    char[] input;

    public Day1() throws IOException {
        this.input = InputLoader.loadToCharArray("/2015/day1_input.txt");
    }

    @Override
    public Integer solvePartOne() {
        Santa santa = new Santa();
        santa.setCurrentFloor(0); // Santa starts from floor 0
        for(char c : input) {
            santa.changeFloors(c);
        }
        System.out.println("Santa is taken to floor: " + santa.getCurrentFloor());
        return santa.getCurrentFloor();
    }

    @Override
    public Integer solvePartTwo() {
        Santa santa = new Santa();
        for (int pos = 0; pos < input.length; pos++) {
            santa.changeFloors(input[pos]);
            if (santa.getCurrentFloor() == -1) {
                System.out.println("Santa is taken to the basement by the character at position: " + (pos + 1));
                return pos + 1;
            }
        }
        throw new IllegalStateException("Santa never enters the basement!");
    }
}
