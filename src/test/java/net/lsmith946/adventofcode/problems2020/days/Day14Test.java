package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day14Test {
    @Test
    public void testDay14Part1() throws IOException, URISyntaxException, InterruptedException {
        Day14 d14 = new Day14();
        Assertions.assertEquals(8570568288597L, d14.solvePartOne());
    }

    @Test
    public void testDay14Part2() throws IOException, URISyntaxException, InterruptedException {
        Day14 d14 = new Day14();
        Assertions.assertEquals(3289441921203L, d14.solvePartTwo());
    }
}
