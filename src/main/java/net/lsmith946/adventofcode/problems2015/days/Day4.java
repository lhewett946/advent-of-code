package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.AdventCoin;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day4 implements Puzzle<Long> {

    String input;

    public Day4() throws IOException {
        this.input = InputLoader.loadToString("/2015/day4_input.txt");
    }

    @Override
    public Long solvePartOne() {
        AdventCoin coin = new AdventCoin(input);
        Long currentNumber = coin.mine("00000");
        System.out.println("The lowest number producing a suitable hash is " + currentNumber);
        return currentNumber;
    }

    @Override
    public Long solvePartTwo() {
        AdventCoin coin = new AdventCoin(input);
        Long currentNumber = coin.mine("000000");
        System.out.println("The lowest number producing a suitable hash is " + currentNumber);
        return currentNumber;
    }
}
