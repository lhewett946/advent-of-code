package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day5 implements Puzzle<Integer> {

    List<String> values;

    public Day5() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadToStringList(2020, 5);
    }

    private int calculateSeatID(String s) {
        int row;
        int column;
        s = s.replace("F", "0")
            .replace("B", "1")
            .replace("L", "0")
            .replace("R", "1");

        row = Integer.parseInt(s.substring(0, 7), 2);
        column = Integer.parseInt(s.substring(7, 10), 2);
        return ((row*8) + column);
    }

    @Override
    public Integer solvePartOne() {
        int highestSeatID = 0;
        for (String s : values) {
            highestSeatID = Math.max(highestSeatID, calculateSeatID(s));
        }
        System.out.println("The highest seat ID is: " + highestSeatID);
        return highestSeatID;
    }

    @Override
    public Integer solvePartTwo() {
        Set<Integer> seatIDs = new HashSet<>();
        for(String s : values) {
            seatIDs.add(calculateSeatID(s));
        }

        // get the highest seat ID from part 1
        long highestSeatID = solvePartOne();

        for(int i = 0; i < highestSeatID; i++) {
            if (!seatIDs.contains(i) &&
                seatIDs.contains(i-1) &&
                seatIDs.contains(i+1)) {
                System.out.println("Your seat ID is: " + i);
                return i;
            }
        }
        return 0; // should never happen
    }
}
