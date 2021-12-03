package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Arrays;

public class Day3 implements Puzzle {

    private char[][] values;

    public Day3() throws IOException {
        this.values = InputLoader.loadTo2DCharArray("/2021/day3_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 3 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int rows = values.length;
        int columns = values[0].length;
        char[] mostCommonBitValues = new char[columns];
        char[] leastCommonBitValues = new char[columns];
        for(int c = 0; c < columns; c++) {
            int countOnes = 0;
            for (char[] value : values) {
                countOnes += Integer.parseInt((String.valueOf(value[c])));
            }
            if (countOnes > rows/2) {
                mostCommonBitValues[c] = '1';
                leastCommonBitValues[c] = '0';
            } else {
                mostCommonBitValues[c] = '0';
                leastCommonBitValues[c] = '1';
            }
        }
        int gammaRate = Integer.parseInt(new String(mostCommonBitValues), 2);
        int epsilonRate = Integer.parseInt(new String(leastCommonBitValues), 2);
        System.out.println("The gamma rate is " + gammaRate);
        System.out.println("The epsilon rate is " + epsilonRate);
        long product = Integer.toUnsignedLong(gammaRate) * Integer.toUnsignedLong(epsilonRate);
        System.out.println("The product of the two rates is " + product);
        return product;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
