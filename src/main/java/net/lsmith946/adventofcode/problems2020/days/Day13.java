package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day13 implements Puzzle {

    List<String> values;

    public Day13() throws IOException {
        InputLoader il = new InputLoader();
        values = il.loadToStringList("/2020/day13_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 13 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int timestampYouArrive = Integer.parseInt(values.get(0));
        String[] busStrings = values.get(1).split(",");
        List<Integer> busWaitTimes = new ArrayList<>();
        for (String bus : busStrings) {
            if (!bus.equals("x")) {
                busWaitTimes.add(Integer.parseInt(bus) - (timestampYouArrive % Integer.parseInt(bus)));
            } else {
                busWaitTimes.add(Integer.MAX_VALUE);
            }
        }
        int waitMinutes = Collections.min(busWaitTimes);
        int busNumber = Integer.parseInt(busStrings[busWaitTimes.indexOf(waitMinutes)]);
        int product = waitMinutes * busNumber;
        System.out.println("The bus number multiplied by the wait in minutes is: " + product);
        return product;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
