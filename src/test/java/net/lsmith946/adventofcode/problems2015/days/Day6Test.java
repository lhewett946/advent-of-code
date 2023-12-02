package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day6Test {

    @Test
    public void testDay6Part1() throws IOException, URISyntaxException, InterruptedException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(569999, d6.solvePartOne());
    }

    @Test
    public void testDay6Part2() throws IOException, URISyntaxException, InterruptedException {
        Day6 d6 = new Day6();
        Assertions.assertEquals(17836115, d6.solvePartTwo());
    }
}
