package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day7Test {

    @Test
    public void testDay7Part1() throws IOException {
        Day7 d7 = new Day7();
        Assertions.assertEquals(336721, d7.solvePartOne());
    }

    @Test
    public void testDay7Part2() throws IOException {
        Day7 d7 = new Day7();
        Assertions.assertEquals(91638945, d7.solvePartTwo());
    }
}
