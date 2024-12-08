package net.lsmith946.adventofcode.problems2024.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day3Test {

    @Test
    public void testDay3Part1() throws IOException, URISyntaxException, InterruptedException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(187825547, d3.solvePartOne());
    }

    @Test
    public void testDay3Part2() throws IOException, URISyntaxException, InterruptedException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(85508223, d3.solvePartTwo());
    }
}
