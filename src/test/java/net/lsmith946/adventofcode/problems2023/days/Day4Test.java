package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day4Test {

    @Test
    public void testDay4Part1() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(28750, d4.solvePartOne());
    }
}
