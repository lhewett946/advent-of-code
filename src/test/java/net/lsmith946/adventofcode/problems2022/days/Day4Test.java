package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.problems2022.days.Day4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day4Test {

    @Test
    public void testDay4Part1() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(507, d4.solvePartOne());
    }

    @Test
    public void testDay4Part2() throws IOException, URISyntaxException, InterruptedException {
        Day4 d4 = new Day4();
        Assertions.assertEquals(897, d4.solvePartTwo());
    }
}
