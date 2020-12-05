package net.lsmith946.adventofcode.problems2020.days;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day5Test {
    @Test
    public void testDay5Part1() throws IOException {
        Day5 d5 = new Day5();
        Assert.assertEquals(970, d5.solvePartOne());
    }

}
