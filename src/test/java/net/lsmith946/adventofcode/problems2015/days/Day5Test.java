package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day5Test {

    @Test
    public void testDay5Part1() throws IOException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(258, d5.solvePartOne());
    }

    @Test
    public void testDay5Part2() throws IOException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(53, d5.solvePartTwo());
    }
}
