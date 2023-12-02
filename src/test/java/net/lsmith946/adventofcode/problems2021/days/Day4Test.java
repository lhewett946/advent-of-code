package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day4Test {

    @Test
    public void testDay4Part1() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(34506, d4.solvePartOne());
    }

    @Test
    public void testDay4Part2() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(7686, d4.solvePartTwo());
    }
}
