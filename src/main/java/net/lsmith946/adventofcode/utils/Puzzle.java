package net.lsmith946.adventofcode.utils;

public interface Puzzle {

    void solve(); // solves both parts of the puzzle and prints to terminal

    long solvePartOne(); // solves only the first part of the puzzle and returns the solution

    long solvePartTwo(); // solves only the second part of the puzzle and returns the solution
}
