package net.lsmith946.adventofcode.problems2023.days;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day7Test {

    @Test
    public void testDay7Part1() throws IOException, URISyntaxException, InterruptedException {
        Day7 d7 = new Day7();
        Assertions.assertEquals(253910319, d7.solvePartOne());
    }
}
