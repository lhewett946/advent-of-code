package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day5Test {

    @Test
    public void testDay5Part1() throws IOException, URISyntaxException, InterruptedException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(551761867, d5.solvePartOne());
    }

    @Test
    public void testDay5Part2() throws IOException, URISyntaxException, InterruptedException {
        Day5 d5 = new Day5();
        Assertions.assertEquals(57451709, d5.solvePartTwo());
    }
}
