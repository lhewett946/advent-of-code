package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day9Test {

    @Test
    public void testDay9Part1() throws IOException {
        Day9 d9 = new Day9();
        Assertions.assertEquals(456, d9.solvePartOne());
    }
}
