package net.lsmith946.adventofcode.problems2020.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day15Test {
    @Test
    public void testDay15Part1() {
        Day15 d15 = new Day15();
        Assertions.assertEquals(536, d15.solvePartOne());
    }

    @Test
    public void testDay15Part2() {
        Day15 d15 = new Day15();
        Assertions.assertEquals(24065124, d15.solvePartTwo());
    }
}
