package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day2 implements Puzzle {

    enum Moves { ROCK, PAPER, SCISSORS }

    private char [][] values;
    private Moves [][] rounds;

    public Day2() throws IOException {
        this.values = InputLoader.loadTo2DCharArray("/2022/day2_input.txt");
        this.rounds = new Moves[2][values.length];
        for(int round = 0; round < values.length; round++) {
            switch (values[round][0]) {
                case 'A' -> rounds[0][round] = Moves.ROCK;
                case 'B' -> rounds[0][round] = Moves.PAPER;
                case 'C' -> rounds[0][round] = Moves.SCISSORS;
            }

            switch (values[round][2]) {
                case 'X' -> rounds[1][round] = Moves.ROCK;
                case 'Y' -> rounds[1][round] = Moves.PAPER;
                case 'Z' -> rounds[1][round] = Moves.SCISSORS;
            }
        }
    }

    private long scoreRound(Moves theirMove, Moves myMove) {
        long score = 0;
        // score for the move I am using
        switch (myMove) {
            case ROCK -> score += 1;
            case PAPER -> score += 2;
            case SCISSORS -> score += 3;
        }
        
        // score for the outcome
        if (theirMove == myMove) {
            // draw scores 3
            score += 3;
        } else if ((myMove == Moves.ROCK && theirMove == Moves.SCISSORS) ||
                (myMove == Moves.PAPER && theirMove == Moves.ROCK) ||
                (myMove == Moves.SCISSORS && theirMove == Moves.PAPER)) {
            score += 6;            
        }
        System.out.println(score);
        return score;
    }
    
    @Override
    public long solvePartOne() {
        // part 1 is to find your score
        long score = 0;
        for (int round = 0; round < rounds[0].length; round++) {
            score += scoreRound(rounds[0][round], rounds[1][round]);
        }
        System.out.println("My total score is " + score);
        return score;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
