package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.ChineseRemainderTheorem;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Day13 implements Puzzle<Long> {

    List<String> values;

    public Day13() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadToStringList(2020, 13);
    }

    @Override
    public Long solvePartOne() {
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
        long product = (long) waitMinutes * busNumber;
        System.out.println("The bus number multiplied by the wait in minutes is: " + product);
        return product;
    }

    @Override
    public Long solvePartTwo() {
        String[] busStrings = values.get(1).split(",");
        Map<Long, Long> busNumToOffset = new HashMap<>();
        long offsetFromStartTime = 0;
        for (String bus : busStrings) {
            if (!bus.equals("x")) {
                long busNumber = Integer.parseInt(bus);
                // the offset needs to be positive for the maths to work
                long offset = (busNumber - (offsetFromStartTime % busNumber)) % busNumber;
                busNumToOffset.put(busNumber, offset);
            }
            offsetFromStartTime++;
        }

        long solution = ChineseRemainderTheorem.solve(busNumToOffset);
        System.out.println("The first timestamp satisfying the pattern is:" + solution);
        return solution;
    }
}
