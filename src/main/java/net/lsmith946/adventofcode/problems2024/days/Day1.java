package net.lsmith946.adventofcode.problems2024.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Day1 implements Puzzle<Long> {

    List<String> values;

    public Day1() throws IOException, URISyntaxException, InterruptedException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList(2024, 1);
    }

    @Override
    public Long solvePartOne() {
        long sum = 0L;
        List<Long> firstList = new ArrayList<>();
        List<Long> secondList = new ArrayList<>();

        for(String s : values) {
            String[] vals = s.split("   ");
            firstList.add(Long.parseLong(vals[0]));
            secondList.add(Long.parseLong(vals[1]));
        }
        Collections.sort(firstList);
        Collections.sort(secondList);

        for(int i = 0; i < firstList.size(); i++) {
            sum += Math.abs(firstList.get(i) - secondList.get(i));
        }
        System.out.println("The total distance between the two lists is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        long sum = 0L;
        return sum;
    }
}
