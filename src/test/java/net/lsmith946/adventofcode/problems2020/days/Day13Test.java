package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day13Test {
    @Test
    public void testDay13Part1() throws IOException, URISyntaxException, InterruptedException {
        Day13 d13 = new Day13();
        Assertions.assertEquals(3269, d13.solvePartOne());
    }

    @Test
    public void testDay13Part2() throws IOException, URISyntaxException, InterruptedException {
        Day13 d13 = new Day13();
        Assertions.assertEquals(Long.parseLong("672754131923874"), d13.solvePartTwo());
    }
}
