package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Present;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day2 implements Puzzle<Long> {

    List<String> input;
    List<Present> presents;

    public Day2() throws IOException, URISyntaxException, InterruptedException {
        this.input = InputLoader.loadToStringList(2015, 2);
        loadPresents();
    }

    private void loadPresents() {
        presents = new ArrayList<>();
        for (String s : input) {
            int length;
            int width;
            int depth;
            String[] dimensions = s.split("x");
            length = Integer.parseInt(dimensions[0]);
            width = Integer.parseInt(dimensions[1]);
            depth = Integer.parseInt(dimensions[2]);
            Present p = new Present(length, width, depth);
            presents.add(p);
        }
    }

    @Override
    public Long solvePartOne() {
        // calculate the amount of wrapping paper needed for the presents
        long wrappingPaperNeeded = 0;
        for (Present p : presents) {
            wrappingPaperNeeded += p.calculateWrappingPaperNeeded();
        }
        System.out.println("The elves need to order " + wrappingPaperNeeded + " square feet of wrapping paper");
        return wrappingPaperNeeded;
    }

    @Override
    public Long solvePartTwo() {
        // calculate the amount of ribbon needed for the presents
        long ribbonNeeded = 0;
        for(Present p : presents) {
            ribbonNeeded += p.calculateRibbonLength();
        }
        System.out.println("The elves need to order " + ribbonNeeded + " feet of ribbon");
        return ribbonNeeded;
    }
}
