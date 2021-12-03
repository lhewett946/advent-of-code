package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day3Test {

    @Test
    public void testDay3Part1() throws IOException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(3320834, d3.solvePartOne());
    }

    @Test
    public void testDay3Part2() throws IOException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(4481199, d3.solvePartTwo());
    }
}
