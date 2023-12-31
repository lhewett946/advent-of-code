package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Santa;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day5 implements Puzzle<Long> {

    List<String> input;

    public Day5() throws IOException, URISyntaxException, InterruptedException {
        this.input = InputLoader.loadToStringList(2015, 5);
    }

    @Override
    public Long solvePartOne() {
        Santa santa = new Santa();
        long niceStrings = santa.countNiceStrings(input);
        System.out.println("There are " + niceStrings + " nice strings.");
        return niceStrings;
    }

    @Override
    public Long solvePartTwo() {
        Santa santa = new Santa();
        long niceStrings = santa.countRevisedNiceStrings(input);
        System.out.println("There are " + niceStrings + " nice strings.");
        return niceStrings;
    }
}
