package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day5Test {

    @Test
    public void testDay5Part1() throws IOException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(5167, d5.solvePartOne());
    }

    @Test
    public void testDay5Part2() throws IOException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(17604, d5.solvePartTwo());
    }
}
