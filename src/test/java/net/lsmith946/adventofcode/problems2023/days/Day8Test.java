package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day8Test {

    @Test
    public void testDay8Part1() throws IOException, URISyntaxException, InterruptedException {
        Day8 d8 = new Day8();
        Assertions.assertEquals(11309, d8.solvePartOne());
    }
}
