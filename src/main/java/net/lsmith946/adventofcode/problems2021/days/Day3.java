package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 implements Puzzle {

    private List<String> values;

    public Day3() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day3_input.txt");
    }

    private char mostCommonBitValue(int column, List<String> values) {
        int countOnes = 0;
        for (String value : values) {
            countOnes += Integer.parseInt((String.valueOf(value.charAt(column))));
        }
        if (countOnes >= Math.ceil((values.size()/2.0))) {
            return '1';
        } else {
            return '0';
        }
    }

    private char leastCommonBitValue(int column, List<String> values) {
        int countOnes = 0;
        for (String value : values) {
            countOnes += Integer.parseInt((String.valueOf(value.charAt(column))));
        }
        if (countOnes >= Math.ceil((values.size()/2.0))) {
            return '0';
        } else {
            return '1';
        }
    }

    @Override
    public long solvePartOne() {
        int columns = values.get(0).length();
        char[] mostCommonBitValues = new char[columns];
        char[] leastCommonBitValues = new char[columns];
        for(int c = 0; c < columns; c++) {
            mostCommonBitValues[c] = mostCommonBitValue(c, values);
            leastCommonBitValues[c] = leastCommonBitValue(c, values);
        }
        int gammaRate = Integer.parseInt(new String(mostCommonBitValues), 2);
        int epsilonRate = Integer.parseInt(new String(leastCommonBitValues), 2);
        System.out.println("The gamma rate is " + gammaRate);
        System.out.println("The epsilon rate is " + epsilonRate);
        long product = (long) gammaRate * epsilonRate;
        System.out.println("The product of the two rates is " + product);
        return product;
    }

    @Override
    public long solvePartTwo() {
        int columns = values.get(0).length();
        // start by finding the oxygen generator rating
        int oxygenGeneratorRating;
        List<String> oxygenGeneratorList = new ArrayList<>(values);
        for(int c = 0; c < columns; c++) {
            int column = c;
            char currentTestChar = mostCommonBitValue(c, oxygenGeneratorList);
            oxygenGeneratorList = oxygenGeneratorList.stream().filter(x -> x.charAt(column) == currentTestChar).toList();
            if (oxygenGeneratorList.size() == 1) {
                break;
            }
        }
        if (oxygenGeneratorList.size() != 1) {
            throw new IllegalStateException("Expected only 1 value in oxygenGeneratorList, but there were " + oxygenGeneratorList.size());
        } else {
            oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorList.get(0), 2);
            System.out.println("The oxygen generator rating is " + oxygenGeneratorRating);
        }

        // then find the CO2 scrubber rating
        int CO2ScrubberRating;
        List<String> CO2ScrubberList = new ArrayList<>(values);
        for(int c = 0; c < columns; c++) {
            int column = c;
            char currentTestChar = leastCommonBitValue(c, CO2ScrubberList);
            CO2ScrubberList = CO2ScrubberList.stream().filter(x -> x.charAt(column) == currentTestChar).toList();
            if (CO2ScrubberList.size() == 1) {
                break;
            }
        }
        if (CO2ScrubberList.size() != 1) {
            throw new IllegalStateException("Expected only 1 value in CO2ScrubberList, but there were " + CO2ScrubberList.size());
        } else {
            CO2ScrubberRating = Integer.parseInt(CO2ScrubberList.get(0), 2);
            System.out.println("The CO2 scrubber rating is " + CO2ScrubberRating);
        }
        long product = (long) oxygenGeneratorRating * CO2ScrubberRating;
        System.out.println("The product of the two ratings is " + product);
        return product;
    }
}
