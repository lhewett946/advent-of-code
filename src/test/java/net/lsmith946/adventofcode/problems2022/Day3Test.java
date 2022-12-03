package net.lsmith946.adventofcode.problems2022;

import net.lsmith946.adventofcode.problems2022.days.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day3Test {

    @Test
    public void testDay3Part1() throws IOException {
        Day3 d3 = new Day3();
        Assertions.assertEquals(7746, d3.solvePartOne());
    }
}
