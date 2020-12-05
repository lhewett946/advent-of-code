package net.lsmith946.adventofcode.problems2020;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day4Test {
    @Test
    public void testDay4Part1() throws IOException {
        Day4 d4 = new Day4();
        Assert.assertEquals(206, d4.solvePartOne());
    }

    @Test
    public void testDay4Part2() throws IOException {
        Day4 d4 = new Day4();
        Assert.assertEquals(123, d4.solvePartTwo());
    }
}
