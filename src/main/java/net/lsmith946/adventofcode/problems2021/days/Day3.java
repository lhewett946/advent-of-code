package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    private char mostCommonBitValue(int column, char[][] vals) {
        int countOnes = 0;
        for (char[] value : values) {
            countOnes += Integer.parseInt((String.valueOf(value[column])));
        }
        if (countOnes >= vals.length/2) {
            return '1';
        } else {
            return '0';
        }
    }

    private char leastCommonBitValue(int column, char[][] vals) {
        int countOnes = 0;
        for (char[] value : values) {
            countOnes += Integer.parseInt((String.valueOf(value[column])));
        }
        if (countOnes >= vals.length/2) {
            return '0';
        } else {
            return '1';
        }
    }

    @Override
    public long solvePartOne() {
        int columns = values[0].length;
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
        return 0;
    }
}
