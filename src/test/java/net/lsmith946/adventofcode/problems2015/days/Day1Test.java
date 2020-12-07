package net.lsmith946.adventofcode.problems2015.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day1Test {

    @Test
    public void testDay1Part1() throws IOException {
        Day1 d1 = new Day1();
        Assert.assertEquals(280, d1.solvePartOne());
    }
}
