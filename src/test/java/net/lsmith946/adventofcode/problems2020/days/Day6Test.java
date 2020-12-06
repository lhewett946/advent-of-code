package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day6Test {
    @Test
    public void testDay6Part1() throws IOException {
        Day6 d6 = new Day6();
        Assert.assertEquals(6534, d6.solvePartOne());
    }

    @Test
    public void testDay6Part2() throws IOException {
        Day6 d6 = new Day6();
        Assert.assertEquals(3402, d6.solvePartTwo());
    }
}
