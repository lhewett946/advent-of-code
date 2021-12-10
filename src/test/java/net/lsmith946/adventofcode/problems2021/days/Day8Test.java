package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day8Test {

    @Test
    public void testDay8Part1() throws IOException {
        Day8 d8 = new Day8();
        Assertions.assertEquals(530, d8.solvePartOne());
    }
}