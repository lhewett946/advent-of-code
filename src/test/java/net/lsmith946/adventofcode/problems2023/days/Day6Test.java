package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day6Test {

    @Test
    public void testDay6Part1() throws IOException, URISyntaxException, InterruptedException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(500346, d6.solvePartOne());
    }

    @Test
    public void testDay6Part2() throws IOException, URISyntaxException, InterruptedException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(42515755, d6.solvePartTwo());
    }
}
