package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day10Test {
    @Test
    public void testDay10Part1() throws IOException {
        Day10 d10 = new Day10();
        Assert.assertEquals(2040, d10.solvePartOne());
    }
}
