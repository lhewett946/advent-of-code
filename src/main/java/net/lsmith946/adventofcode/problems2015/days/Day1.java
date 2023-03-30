package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.Counter;
import net.lsmith946.adventofcode.utils.CounterOperations;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public class Day1 implements Puzzle<Integer> {

    char[] input;

    public Day1() throws IOException {
        this.input = InputLoader.loadToCharArray("/2015/day1_input.txt");
    }

    @Override
    public Integer solvePartOne() {
        Counter currentFloor = new Counter();
        for (Character c : input) {
            if (c.equals('(')) {
                currentFloor.modifyCounter(CounterOperations.INCREMENT, 1);
            } else {
                currentFloor.modifyCounter(CounterOperations.DECREMENT, 1);
            }
        }
        System.out.println("Santa is taken to floor: " + currentFloor.getCurrentValue());
        return currentFloor.getCurrentValue();
    }

    @Override
    public Integer solvePartTwo() {
        Counter currentFloor = new Counter();
        for (int pos = 0; pos < input.length; pos++) {
            if (input[pos] == '(') {
                currentFloor.modifyCounter(CounterOperations.INCREMENT, 1);
            } else {
                currentFloor.modifyCounter(CounterOperations.DECREMENT, 1);
            }
            if (currentFloor.getCurrentValue() == -1) {
                System.out.println("Santa is taken to the basement by the character at position: " + (pos + 1));
                return pos + 1;
            }
        }
        throw new IllegalStateException("Santa never enters the basement!");
    }
}
