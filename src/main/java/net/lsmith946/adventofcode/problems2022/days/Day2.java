package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;

public final class Day2 implements Puzzle {

    enum Moves { ROCK, PAPER, SCISSORS }

    private final char [][] values;
    private final Moves [][] rounds;

    public Day2() throws IOException {
        this.values = InputLoader.loadTo2DCharArray("/2022/day2_input.txt");
        this.rounds = new Moves[2][values.length];
    }

    private void decodeInputPart1() {
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

    private void decodeInputPart2() {
        for(int round = 0; round < values.length; round++) {
            switch (values[round][0]) {
                case 'A' -> rounds[0][round] = Moves.ROCK;
                case 'B' -> rounds[0][round] = Moves.PAPER;
                case 'C' -> rounds[0][round] = Moves.SCISSORS;
            }

            switch (values[round][2]) {
                case 'X': // lose in this case
                    switch(rounds[0][round]) {
                        case ROCK -> rounds[1][round] = Moves.SCISSORS;
                        case PAPER -> rounds[1][round] = Moves.ROCK;
                        case SCISSORS -> rounds[1][round] = Moves.PAPER;
                    }
                    break;
                case 'Y': // draw means play the same move
                    rounds[1][round] = rounds[0][round];
                    break;
                case 'Z': // win in this case
                    switch(rounds[0][round]) {
                        case ROCK -> rounds[1][round] = Moves.PAPER;
                        case PAPER -> rounds[1][round] = Moves.SCISSORS;
                        case SCISSORS -> rounds[1][round] = Moves.ROCK;
                    }
                    break;
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
        return score;
    }
    
    @Override
    public long solvePartOne() {
        // part 1 is to find your score based on one way of decoding the input
        long score = 0;
        decodeInputPart1();
        for (int round = 0; round < rounds[0].length; round++) {
            score += scoreRound(rounds[0][round], rounds[1][round]);
        }
        System.out.println("My total score is " + score);
        return score;
    }

    @Override
    public long solvePartTwo() {
        // part 2 is to find your score based on another way of decoding the input
        long score = 0;
        decodeInputPart2();
        for (int round = 0; round < rounds[0].length; round++) {
            score += scoreRound(rounds[0][round], rounds[1][round]);
        }
        System.out.println("My total score is " + score);
        return score;
    }
}
