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
    List<Long> firstList;
    List<Long> secondList;

    public Day1() throws IOException, URISyntaxException, InterruptedException {
        values = new ArrayList<>();
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        this.values = InputLoader.loadToStringList(2024, 1);
        getNumbersInList();
    }

    private void getNumbersInList() {
        for(String s : values) {
            String[] vals = s.split("   ");
            firstList.add(Long.parseLong(vals[0]));
            secondList.add(Long.parseLong(vals[1]));
        }
    }

    @Override
    public Long solvePartOne() {
        long sum = 0L;

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
        for(int i = 0; i < firstList.size(); i++) {
            long locationID = firstList.get(i);
            long count = Collections.frequency(secondList, locationID);
            sum += locationID * count;
        }
        System.out.println("The similarity score of the two lists is " + sum);
        return sum;
    }
}
