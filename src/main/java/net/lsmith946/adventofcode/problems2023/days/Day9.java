package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.ExtrapolationDirection;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class Day9 implements Puzzle<Long> {

    List<String> values;

    public Day9() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadToStringList(2023, 9);
    }

    private boolean allZeros(Long[] deltas) {
        for(Long l : deltas) {
            if (l != 0) {
                return false;
            }
        }
        return true;
    }

    private long extrapolate(Long[] existingValues, ExtrapolationDirection direction) {
        Long[] valuesDeltas =  new Long[existingValues.length-1];
        for(int i = 0; i < valuesDeltas.length; i++) {
            valuesDeltas[i] = existingValues[i+1] - existingValues[i];
        }

        if (allZeros(valuesDeltas)) {
            return existingValues[0];
        }
        else {
            long nextDelta;
            if (direction == ExtrapolationDirection.FORWARD) {
                nextDelta = existingValues[existingValues.length - 1] + extrapolate(valuesDeltas, ExtrapolationDirection.FORWARD);
            }
            else {
                nextDelta = existingValues[0] - extrapolate(valuesDeltas, ExtrapolationDirection.BACKWARD);
            }
            return nextDelta;
        }
    }

    @Override
    public Long solvePartOne() {
        Long extrapolatedValuesSum = 0L;
        for(String s : values) {
            String[] measurementsStr = StringUtils.split(s);
            Long[] measurements = new Long[measurementsStr.length];
            for(int i = 0; i < measurements.length; i++) {
                measurements[i] = Long.parseLong(measurementsStr[i]);
            }

            // extrapolate the next value and add it to the list
            long nextValue = extrapolate(measurements, ExtrapolationDirection.FORWARD);
            extrapolatedValuesSum += nextValue;
        }
        System.out.println("The sum of the extrapolated values is " + extrapolatedValuesSum);
        return extrapolatedValuesSum;
    }

    @Override
    public Long solvePartTwo() {
        Long extrapolatedValuesSum = 0L;
        for(String s : values) {
            String[] measurementsStr = StringUtils.split(s);
            Long[] measurements = new Long[measurementsStr.length];
            for(int i = 0; i < measurements.length; i++) {
                measurements[i] = Long.parseLong(measurementsStr[i]);
            }

            // extrapolate the next value and add it to the list
            long nextValue = extrapolate(measurements, ExtrapolationDirection.BACKWARD);
            extrapolatedValuesSum += nextValue;
        }
        System.out.println("The sum of the extrapolated values is " + extrapolatedValuesSum);
        return extrapolatedValuesSum;
    }
}
