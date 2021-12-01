package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day1Test {

    @Test
    public void testDay1Part1() throws IOException {
        Day1 d1 = new Day1();
        Assertions.assertEquals(1482, d1.solvePartOne());
    }

    @Test
    public void testDay1Part2() throws IOException {
        Day1 d1 = new Day1();
        Assertions.assertEquals(1518, d1.solvePartTwo());
    }

}
