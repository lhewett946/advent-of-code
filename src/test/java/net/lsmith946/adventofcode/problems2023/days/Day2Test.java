package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day2Test {

    @Test
    public void testDay2Part1() throws IOException, URISyntaxException, InterruptedException {
        Day2 d2 = new Day2();
        Assertions.assertEquals(2149, d2.solvePartOne());
    }

    @Test
    public void testDay2Part2() throws IOException, URISyntaxException, InterruptedException {
        Day2 d2 = new Day2();
        Assertions.assertEquals(71274, d2.solvePartTwo());
    }
}
