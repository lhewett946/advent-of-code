package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day6Test {

    @Test
    public void testDay6Part1() throws IOException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(569999, d6.solvePartOne());
    }

    @Test
    public void testDay6Part2() throws IOException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(0, d6.solvePartTwo());
    }
}
