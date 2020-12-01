package net.lsmith946.adventofcode2020;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day1Test {

    @Test
    public void testDay1Part1() throws IOException {
        Day1 d1 = new Day1();
        Assert.assertEquals(691771, d1.solvePartOne());
    }

    @Test
    public void testDay1Part2() throws IOException {
        Day1 d1 = new Day1();
        Assert.assertEquals(232508760, d1.solvePartTwo());
    }
}
