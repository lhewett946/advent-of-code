package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day3Test {
    @Test
    public void testDay3Part1() throws IOException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(195, d3.solvePartOne());
    }

    @Test
    public void testDay3Part2() throws IOException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(Long.parseLong("3772314000"), d3.solvePartTwo());
    }
}