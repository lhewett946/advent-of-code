package net.lsmith946.adventofcode2020;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day2Test {
    @Test
    public void testDay2Part1() throws IOException {
        Day2 d2 = new Day2();
        Assert.assertEquals(447, d2.solvePartOne());
    }
}
