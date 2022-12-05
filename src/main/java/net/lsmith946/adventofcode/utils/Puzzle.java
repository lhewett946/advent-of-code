package net.lsmith946.adventofcode.utils;

public interface Puzzle <T> {

    default void solve() {
        // solves both parts of the puzzle and prints to terminal
        System.out.println("------" + this.getClass().getSimpleName() + "------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    T solvePartOne(); // solves only the first part of the puzzle and returns the solution

    T solvePartTwo(); // solves only the second part of the puzzle and returns the solution
}
