package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.problems2022.days.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day5Test {

    @Test
    public void testDay5Part1() throws IOException, URISyntaxException, InterruptedException {
        Day5 d5 = new Day5();
        Assertions.assertEquals("SVFDLGLWV", d5.solvePartOne());
    }

    @Test
    public void testDay5Part2() throws IOException, URISyntaxException, InterruptedException {
        Day5 d5 = new Day5();
        Assertions.assertEquals("DCVTCVPCL", d5.solvePartTwo());
    }
}
