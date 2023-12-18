package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day10Test {

    @Test
    public void testDay10Part1() throws IOException, URISyntaxException, InterruptedException {
        Day10 d10 = new Day10();
        Assertions.assertEquals(7102, d10.solvePartOne());
    }

    @Test
    public void testDay10Part2() throws IOException, URISyntaxException, InterruptedException {
        Day10 d10 = new Day10();
        Assertions.assertEquals(363, d10.solvePartTwo());
    }
}
