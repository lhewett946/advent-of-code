package net.lsmith946.adventofcode.problems2021;

import java.util.Arrays;

public class BingoCard {

    private int [][] numbers;
    private boolean [][] called;
    private int rows;
    private int columns;
    private boolean hasWon;

    public BingoCard(int[][] numbers) {
        this.numbers = numbers;
        rows = numbers.length;
        columns = numbers[0].length;
        called = new boolean[rows][columns];
        for(int r = 0; r < rows; r++) {
            Arrays.fill(called[r], false);
        }
        hasWon = false;
    }

    private void markNumber(int number) {
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if (numbers[r][c] == number) {
                    called[r][c] = true;
                }
            }
        }
    }

    private boolean checkForWin() {
        boolean[] winningRow = new boolean[rows];
        boolean[] winningColumn = new boolean[columns];
        Arrays.fill(winningRow, true);
        Arrays.fill(winningColumn, true);
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                winningRow[r] &= called[r][c];
                winningColumn[c] &= called[r][c];
            }
        }
        // check for any winning rows
        for(boolean b : winningRow) {
            if (b) {
                hasWon = true;
                break;
            }
        }
        // check for any winning columns
        for(boolean b : winningColumn) {
            if (b) {
                hasWon = true;
                break;
            }
        }
        return hasWon;
    }

    public boolean processTurn(int number) {
        if (!hasWon) {
            markNumber(number);
            return checkForWin();
        }
        else {
            return false;
        }
    }

    public int calculateScore() {
        int score = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if (!called[r][c]) {
                    score+= numbers[r][c];
                }
            }
        }
        return score;
    }
}
