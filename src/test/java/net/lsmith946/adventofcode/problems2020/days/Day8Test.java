package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day8Test {
    @Test
    public void testDay8Part1() throws IOException {
        Day8 d8 = new Day8();
        Assert.assertEquals(1610, d8.solvePartOne());
    }
}
