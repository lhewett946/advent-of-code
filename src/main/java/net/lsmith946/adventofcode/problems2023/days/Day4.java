package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.Scratchcard;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Day4 implements Puzzle<Long> {

    List<String> values;

    public Day4() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadToStringList(2023, 4);
    }

    @Override
    public Long solvePartOne() {
        long sum = 0L;
        for(String s : values) {
            Scratchcard currentCard = new Scratchcard(s);
            sum += currentCard.calculateScore();
        }
        System.out.println("The elf's pile of scratchcards is worth " + sum + " points");
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
