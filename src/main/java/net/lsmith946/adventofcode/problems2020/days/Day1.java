package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import net.lsmith946.adventofcode.utils.SumUtils;

import java.io.IOException;
import java.util.Set;

public class Day1 implements Puzzle {

    private Set<Integer> values;

    public Day1() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToIntSet("/2020/day1_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 1 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        // part 1 is to find two integers from the list which sum to 2020
        // and then find the product of those two integers
        long product = 1;
        Set<Integer> intsMatchingSum = SumUtils.findUniqueIntsToSumTo(2020, 2, values);
        for (Integer i : intsMatchingSum) {
            product *= i;
        }
        System.out.println("The product of the two values is " + product);
        return product;
    }

    @Override
    public long solvePartTwo() {
        // part 2 is to find three integers from the list which sum to 2020
        // and then find the product of those three integers
        long product = 1;
        Set<Integer> intsMatchingSum = SumUtils.findUniqueIntsToSumTo(2020, 3, values);
        for (Integer i : intsMatchingSum) {
            product *= i;
        }
        System.out.println("The product of the three values is " + product);
        return product;
    }
}
