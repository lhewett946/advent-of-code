package net.lsmith946.adventofcode.problems2022;

import net.lsmith946.adventofcode.problems2022.days.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day5Test {

    @Test
    public void testDay5Part1() throws IOException {
        Day5 d5 = new Day5();
        //noinspection SpellCheckingInspection
        Assertions.assertEquals("SVFDLGLWV", d5.solvePartOne());
    }

    @Test
    public void testDay5Part2() throws IOException {
        Day5 d5 = new Day5();
        //noinspection SpellCheckingInspection
        Assertions.assertEquals("DCVTCVPCL", d5.solvePartTwo());
    }
}
