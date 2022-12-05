package net.lsmith946.adventofcode.problems2021.days;

import net.lsmith946.adventofcode.problems2021.BingoCard;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 implements Puzzle<Long> {

    private List<String> values;
    private List<BingoCard> cards;
    private List<Integer> numbersToCall;

    public Day4() throws IOException {
        this.values = InputLoader.loadToStringList("/2021/day4_input.txt");
        cards = new ArrayList<>();
        numbersToCall = new ArrayList<>();
        parseInput();
    }

    private void parseInput() {
        // first string is the order of the numbers to be called
        String[] numberOrder = values.get(0).split(",");
        for(String s : numberOrder) {
            numbersToCall.add(Integer.parseInt(s));
        }
        // remove the first string after processing it
        values.remove(0);

        // remove the blank line at the start of the list of cards
        values.remove(0);

        // now load the bingo cards
        int[][] numbers = new int[5][5];
        int currentRow = 0;
        BingoCard currentCard;
        for(String s : values) {
            if (s.isBlank()) {
                currentCard = new BingoCard(numbers);
                cards.add(currentCard);
                numbers = new int[5][5];
                currentRow = 0;
            } else {
                s = s.stripLeading();
                String[] numbersStr = s.split("\\s+"); // split on any whitespace, regardless of its length
                for(int c = 0; c < numbersStr.length; c++){
                    numbers[currentRow][c] = Integer.parseInt(numbersStr[c]);
                }
                currentRow++;
            }
        }
        // add the last card, since that one will not have a blank line following it
        currentCard = new BingoCard(numbers);
        cards.add(currentCard);
    }

    @Override
    public Long solvePartOne() {
        for(Integer currentNumber : numbersToCall) {
            for(BingoCard card : cards) {
                if (card.processTurn(currentNumber)) {
                    long product = (long) currentNumber * card.calculateScore();
                    System.out.println("The product of the current number and the first winning cards score is " + product);
                    return product;
                }
            }
        }
        return (long) 0; // should never get here
    }

    @Override
    public Long solvePartTwo() {
        int lastWinnerScore = 0;
        int lastWinnerNumber = 0;
        for(Integer currentNumber : numbersToCall) {
            for(BingoCard card : cards) {
                if (card.processTurn(currentNumber)) {
                    lastWinnerScore = card.calculateScore();
                    lastWinnerNumber = currentNumber;
                }
            }
        }

        long product = (long) lastWinnerNumber * lastWinnerScore;
        System.out.println("The product of the current number and the last winning cards score is " + product);
        return product;
    }
}
