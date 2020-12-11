package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Arrays;

public class Day11 implements Puzzle {

    char[][] seatingArea;

    public Day11() throws IOException {
        InputLoader il = new InputLoader();
        // load to an integer set to ensure no duplicates (as this is assumed by other code)
        seatingArea = il.loadTo2DCharArray("/2020/day11_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 11 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    private int countOccupiedAdjacentSeats(int rowCheck, int columnCheck) {
        int occupiedSeats = 0;

        for (int row = rowCheck - 1; row <= rowCheck + 1; row++) {
            for (int column = columnCheck - 1; column <= columnCheck + 1; column++) {
                if (row != rowCheck || column != columnCheck) {   // don't check the current location, only the surrounding ones
                    try {
                        if (seatingArea[row][column] == '#') {
                            occupiedSeats++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // if access goes out of bounds, we are at the edge of the seating area
                        // we can safely ignore out of bounds accesses
                    }
                }

            }
        }
        return occupiedSeats;
    }

    @Override
    public long solvePartOne() {
        int totalRows, totalColumns;
        totalRows = seatingArea.length;
        totalColumns = seatingArea[0].length;
        char[][] newSeatingArea = new char[totalRows][totalColumns];
        boolean changeMade;
        do {
            changeMade = false;
            for (int row = 0; row < totalRows; row++) {
                newSeatingArea[row] = Arrays.copyOf(seatingArea[row], totalColumns);
                for (int column = 0; column < totalColumns; column++) {
                    if (seatingArea[row][column] != '.') { // if this position is the floor, skip it since it never changes
                        // determine the number of occupied seats around the current seat
                        int occupiedSeats = countOccupiedAdjacentSeats(row, column);
                        if (seatingArea[row][column] == 'L' && occupiedSeats == 0) {
                            // if the seat is not currently occupied, and all the surrounding seats are empty
                            // it will become occupied
                            newSeatingArea[row][column] = '#';
                            changeMade = true;
                        } else if (seatingArea[row][column] == '#' && occupiedSeats >= 4) {
                            // if the seat is currently occupied, along with at least 4 of the surrounding seats
                            // if will become unoccupied
                            newSeatingArea[row][column] = 'L';
                            changeMade = true;
                        }
                    }
                }
            }
            // copy the new seating area over ready for the next iteration
            for (int row = 0; row < totalRows; row++) {
                seatingArea[row] = Arrays.copyOf(newSeatingArea[row], totalColumns);
            }
        } while (changeMade);

        // once stability is achieved, count the number of occupied seats
        int finalOccupiedSeats = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (seatingArea[row][column] == '#') {
                    finalOccupiedSeats++;
                }
            }
        }
        System.out.println("The final number of occupied seats is: " + finalOccupiedSeats);
        return finalOccupiedSeats;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
