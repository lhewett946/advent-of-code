package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day16Test {
    @Test
    public void testDay16Part1() throws IOException, URISyntaxException, InterruptedException {
        Day16 d16 = new Day16();
        Assertions.assertEquals(22977, d16.solvePartOne());
    }
}
