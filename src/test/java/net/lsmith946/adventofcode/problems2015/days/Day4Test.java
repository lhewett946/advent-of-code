package net.lsmith946.adventofcode.problems2015.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class Day4Test {

    @Test
    public void testDay4Part1() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(282749, d4.solvePartOne());
    }

    @Test
    public void testDay4Part2() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(9962624, d4.solvePartTwo());
    }
}
