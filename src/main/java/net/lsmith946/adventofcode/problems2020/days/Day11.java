package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Arrays;

public class Day11 implements Puzzle {

    char[][] currentSeatingArea;
    char[][] originalSeatingArea;
    int totalRows, totalColumns;

    public Day11() throws IOException {
        currentSeatingArea = InputLoader.loadTo2DCharArray("/2020/day11_input.txt");
        totalRows = currentSeatingArea.length;
        totalColumns = currentSeatingArea[0].length;
        // copy the loaded seating area to a reference array
        // as part 1 will modify it but the original is needed for part 2
        originalSeatingArea = new char[totalRows][totalColumns];
        for (int row = 0; row < totalRows; row++) {
            originalSeatingArea[row] = Arrays.copyOf(currentSeatingArea[row], totalColumns);
        }
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
                        if (currentSeatingArea[row][column] == '#') {
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
        char[][] newSeatingArea = new char[totalRows][totalColumns];
        boolean changeMade;
        do {
            changeMade = false;
            for (int row = 0; row < totalRows; row++) {
                newSeatingArea[row] = Arrays.copyOf(currentSeatingArea[row], totalColumns);
                for (int column = 0; column < totalColumns; column++) {
                    if (currentSeatingArea[row][column] != '.') { // if this position is the floor, skip it since it never changes
                        // determine the number of occupied seats around the current seat
                        int occupiedSeats = countOccupiedAdjacentSeats(row, column);
                        if (currentSeatingArea[row][column] == 'L' && occupiedSeats == 0) {
                            // if the seat is not currently occupied, and all the surrounding seats are empty
                            // it will become occupied
                            newSeatingArea[row][column] = '#';
                            changeMade = true;
                        } else if (currentSeatingArea[row][column] == '#' && occupiedSeats >= 4) {
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
                currentSeatingArea[row] = Arrays.copyOf(newSeatingArea[row], totalColumns);
            }
        } while (changeMade);

        // once stability is achieved, count the number of occupied seats
        int finalOccupiedSeats = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (currentSeatingArea[row][column] == '#') {
                    finalOccupiedSeats++;
                }
            }
        }
        System.out.println("The final number of occupied seats is: " + finalOccupiedSeats);
        return finalOccupiedSeats;
    }

    private boolean foundOccupiedSeat(int startRow, int startColumn, int horizontalChange, int verticalChange) {
        int currentHorizontalPosition = startColumn + horizontalChange;
        int currentVerticalPosition = startRow + verticalChange;
        while (currentVerticalPosition >= 0 && currentVerticalPosition < totalRows &&
                currentHorizontalPosition >= 0 && currentHorizontalPosition < totalColumns) {
            if (currentSeatingArea[currentVerticalPosition][currentHorizontalPosition] == '#') {
                return true;
            } else if (currentSeatingArea[currentVerticalPosition][currentHorizontalPosition] == 'L') {
                return false;
            }
            currentHorizontalPosition += horizontalChange;
            currentVerticalPosition += verticalChange;
        }
        return false;
    }

    private int countOccupiedVisibleSeats(int rowCheck, int columnCheck) {
        int occupiedSeats = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (foundOccupiedSeat(rowCheck, columnCheck, i, j)) {
                    occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }

    @Override
    public long solvePartTwo() {
        // reload original seating area
        for (int row = 0; row < totalRows; row++) {
            currentSeatingArea[row] = Arrays.copyOf(originalSeatingArea[row], totalColumns);
        }
        char[][] newSeatingArea = new char[totalRows][totalColumns];
        boolean changeMade;
        do {
            changeMade = false;
            for (int row = 0; row < totalRows; row++) {
                newSeatingArea[row] = Arrays.copyOf(currentSeatingArea[row], totalColumns);
                for (int column = 0; column < totalColumns; column++) {
                    if (currentSeatingArea[row][column] != '.') { // if this position is the floor, skip it since it never changes
                        // determine the number of occupied seats around the current seat
                        int occupiedSeats = countOccupiedVisibleSeats(row, column);
                        if (currentSeatingArea[row][column] == 'L' && occupiedSeats == 0) {
                            // if the seat is not currently occupied, and all the visible seats are empty
                            // it will become occupied
                            newSeatingArea[row][column] = '#';
                            changeMade = true;
                        } else if (currentSeatingArea[row][column] == '#' && occupiedSeats >= 5) {
                            // if the seat is currently occupied, along with at least 5 of the visible seats
                            // if will become unoccupied
                            newSeatingArea[row][column] = 'L';
                            changeMade = true;
                        }
                    }
                }
            }
            // copy the new seating area over ready for the next iteration
            for (int row = 0; row < totalRows; row++) {
                currentSeatingArea[row] = Arrays.copyOf(newSeatingArea[row], totalColumns);
            }
        } while (changeMade);

        // once stability is achieved, count the number of occupied seats
        int finalOccupiedSeats = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (currentSeatingArea[row][column] == '#') {
                    finalOccupiedSeats++;
                }
            }
        }
        System.out.println("The final number of occupied seats is: " + finalOccupiedSeats);
        return finalOccupiedSeats;
    }
}
