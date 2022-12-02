package net.lsmith946.adventofcode.problems2022;

import net.lsmith946.adventofcode.problems2022.days.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day2Test {

    @Test
    public void testDay2Part1() throws IOException {
        Day2 d2 = new Day2();
        Assertions.assertEquals(12156, d2.solvePartOne());
    }
}
