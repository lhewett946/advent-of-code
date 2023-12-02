package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.problems2022.days.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day3Test {

    @Test
    public void testDay3Part1() throws IOException, URISyntaxException, InterruptedException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(7746, d3.solvePartOne());
    }

    @Test
    public void testDay3Part2() throws IOException, URISyntaxException, InterruptedException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(2604, d3.solvePartTwo());
    }
}
