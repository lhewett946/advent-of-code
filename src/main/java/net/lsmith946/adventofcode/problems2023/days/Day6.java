package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class Day6 implements Puzzle<Long> {

    List<String> values;

    public Day6() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadToStringList(2023, 6);
    }

    @Override
    public Long solvePartOne() {
        String[] raceTimes = StringUtils.split(values.get(0));
        String[] raceDistances = StringUtils.split(values.get(1));
        long product = 1;
        for(int race = 1; race < raceTimes.length; race++) {
            long waysToWin = 0;
            long raceDuration = Long.parseLong(raceTimes[race]);
            long recordDistance = Long.parseLong(raceDistances[race]);
            for(long buttonHold = 0; buttonHold < Long.parseLong(raceTimes[race]); buttonHold++) {
                long distanceCovered = buttonHold * (raceDuration - buttonHold);
                if (distanceCovered > recordDistance) {
                    waysToWin++;
                }
            }
            product = product * waysToWin;
        }
        System.out.println("The product of the number of ways to win each race is " + product);
        return product;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
