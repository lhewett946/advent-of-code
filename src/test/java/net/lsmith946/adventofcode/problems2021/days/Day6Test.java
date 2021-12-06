package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day6Test {

    @Test
    public void testDay6Part1() throws IOException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(362740, d6.solvePartOne());
    }

    @Test
    public void testDay6Part2() throws IOException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(1644874076764L, d6.solvePartTwo());
    }
}
