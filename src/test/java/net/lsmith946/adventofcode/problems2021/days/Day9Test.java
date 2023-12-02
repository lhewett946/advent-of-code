package net.lsmith946.adventofcode.problems2021.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day9Test {

    @Test
    public void testDay9Part1() throws IOException, URISyntaxException, InterruptedException {
        Day9 d9 = new Day9();
        Assertions.assertEquals(456, d9.solvePartOne());
    }
}
