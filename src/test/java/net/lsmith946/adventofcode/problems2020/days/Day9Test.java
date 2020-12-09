package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day9Test {
    @Test
    public void testDay9Part1() throws IOException {
        Day9 d9 = new Day9();
        Assert.assertEquals(27911108, d9.solvePartOne());
    }
}
