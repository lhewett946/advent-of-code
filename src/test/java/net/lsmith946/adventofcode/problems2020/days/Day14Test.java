package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day14Test {
    @Test
    public void testDay14Part1() throws IOException {
        Day14 d14 = new Day14();
        Assert.assertEquals(8570568288597L, d14.solvePartOne());
    }

    @Test
    public void testDay14Part2() throws IOException {
        Day14 d14 = new Day14();
        Assert.assertEquals(3289441921203L, d14.solvePartTwo());
    }
}
