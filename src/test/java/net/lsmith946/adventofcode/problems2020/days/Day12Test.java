package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day12Test {
    @Test
    public void testDay12Part1() throws IOException {
        Day12 d12 = new Day12();
        Assert.assertEquals(1457, d12.solvePartOne());
    }

    @Test
    public void testDay12Part2() throws IOException {
        Day12 d12 = new Day12();
        Assert.assertEquals(106860, d12.solvePartTwo());
    }
}
