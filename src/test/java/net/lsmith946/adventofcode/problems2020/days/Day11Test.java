package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day11Test {
    @Test
    public void testDay11Part1() throws IOException, URISyntaxException, InterruptedException {
        Day11 d11 = new Day11();
        Assertions.assertEquals(2418, d11.solvePartOne());
    }

    @Test
    public void testDay11Part2() throws IOException, URISyntaxException, InterruptedException {
        Day11 d11 = new Day11();
        Assertions.assertEquals(2144, d11.solvePartTwo());
    }
}
