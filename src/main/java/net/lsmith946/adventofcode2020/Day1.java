package net.lsmith946.adventofcode2020;

import java.io.IOException;
import java.util.Set;

public class Day1 {

    private Set<Integer> values;

    public Day1() throws IOException {
        this.values = InputLoader.loadToIntSet(getClass().getResource("/day1_input.txt").getFile());
    }

    public void solve() {
        System.out.println("--- Day 1 ---");
        solvePartOne();
    }

    public int solvePartOne() {
        // part 1 is to find two integers from the list which sum to 2020
        // and then find the product of those two integers
        int product = 0;
        for (Integer i : values) {
            Integer remaining = 2020 - i;
            if (values.contains(remaining)) {
                product = i * remaining;
                System.out.println("--- PART ONE ---");
                System.out.println("The two values found are " + i.toString() + " and " + remaining.toString());
                System.out.println("The product of these two values is " + product);
                break;
            }
        }
        return product;
    }
}
