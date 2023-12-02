package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day7Test {

    @Test
    public void testDay7Part1() throws IOException, URISyntaxException, InterruptedException {
        Day7 d7 = new Day7();
        Assertions.assertEquals(956, d7.solvePartOne());
    }

    @Test
    public void testDay7Part2() throws IOException, URISyntaxException, InterruptedException {
        Day7 d7 = new Day7();
        Assertions.assertEquals(40149, d7.solvePartTwo());
    }
}
