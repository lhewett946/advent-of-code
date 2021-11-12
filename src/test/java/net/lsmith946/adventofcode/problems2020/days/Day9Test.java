package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day9Test {
    @Test
    public void testDay9Part1() throws IOException {
        Day9 d9 = new Day9();
        Assertions.assertEquals(27911108, d9.solvePartOne());
    }

    @Test
    public void testDay9Part2() throws IOException {
        Day9 d9 = new Day9();
        Assertions.assertEquals(4023754, d9.solvePartTwo());
    }
}
