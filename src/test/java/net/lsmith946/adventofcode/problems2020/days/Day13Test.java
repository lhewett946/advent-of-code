package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day13Test {
    @Test
    public void testDay13Part1() throws IOException {
        Day13 d13 = new Day13();
        Assert.assertEquals(3269, d13.solvePartOne());
    }
}
