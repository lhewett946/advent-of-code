package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 implements Puzzle {

    List<String> values;

    public Day6() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day6_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 6 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        int totalTrueAnswers = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (String s: values) {
           if (s.equals("")) {
               // if this is an empty string, count the number of true answers in the combined string
               totalTrueAnswers += uniqueChars.size();
               uniqueChars.clear();
           } else {
               char[] charsInString = s.toCharArray();
               for (char c: charsInString) {
                   uniqueChars.add(c);
               }
           }
        }
        // count up for the last set of strings
        totalTrueAnswers += uniqueChars.size();
        System.out.println("The total number of true answers given is: " + totalTrueAnswers);
        return totalTrueAnswers;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
