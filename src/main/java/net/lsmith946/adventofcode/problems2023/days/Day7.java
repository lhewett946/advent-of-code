package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.CamelClassHand;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Day7 implements Puzzle<Long> {

    private List<String> values = new ArrayList<>();

    public Day7() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadToStringList(2023, 7);

    }

    @Override
    public Long solvePartOne() {
        List<CamelClassHand> hands = new ArrayList<>();
        for(String s : values) {
            String[] handStr = StringUtils.split(s);
            CamelClassHand hand = new CamelClassHand(handStr[0], Integer.parseInt(handStr[1]));
            hands.add(hand);
        }

        long totalWinnings = 0;
        Collections.sort(hands);
        for(int rank = 0; rank < hands.size(); rank++) {
            totalWinnings += (long) (rank+1) * hands.get(rank).getBid();
        }
        System.out.println("The total winnings from the game is " + totalWinnings);
        return totalWinnings;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
