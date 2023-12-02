package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day1Test {

    @Test
    public void testDay1Part1() throws IOException, URISyntaxException, InterruptedException {
        Day1 d1 = new Day1();
        Assertions.assertEquals(280, d1.solvePartOne());
    }

    @Test
    public void testDay1Part2() throws IOException, URISyntaxException, InterruptedException {
        Day1 d1 = new Day1();
        Assertions.assertEquals(1797, d1.solvePartTwo());
    }
}
