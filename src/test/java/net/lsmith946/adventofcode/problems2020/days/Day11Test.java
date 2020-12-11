package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day11Test {
    @Test
    public void testDay11Part1() throws IOException {
        Day11 d11 = new Day11();
        Assert.assertEquals(2418, d11.solvePartOne());
    }
}
