package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day7Test {
    @Test
    public void testDay7Part1() throws IOException {
        Day7 d7 = new Day7();
        Assert.assertEquals(224, d7.solvePartOne());
    }

    @Test
    public void testDay7Part2() throws IOException {
        Day7 d7 = new Day7();
        Assert.assertEquals(1488, d7.solvePartTwo());
    }
}
