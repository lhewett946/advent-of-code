package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 implements Puzzle {

    List<String> values;

    public Day6() throws IOException {
        this.values = InputLoader.loadToStringList("/2020/day6_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 6 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int totalTrueAnswers = 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (String s : values) {
            if (s.equals("")) {
                // if this is an empty string, count the number of true answers
                totalTrueAnswers += uniqueChars.size();
                uniqueChars.clear();
            } else {
                char[] charsInString = s.toCharArray();
                for (char c : charsInString) {
                   uniqueChars.add(c);
               }
           }
        }
        // count up for the last set of strings
        totalTrueAnswers += uniqueChars.size();
        System.out.println("The total number of true answers given is: " + totalTrueAnswers);
        return totalTrueAnswers;
    }

    private int countCombinedAnswers(String combinedString, int peopleInGroup) {
        int trueAnswersInGroup = 0;
        while(!combinedString.equals("")) {
            if (peopleInGroup == StringUtils.countMatches(combinedString, combinedString.charAt(0))) {
                trueAnswersInGroup++;
            }
            combinedString = combinedString.replaceAll(String.valueOf(combinedString.charAt(0)), "");
        }
        return trueAnswersInGroup;
    }
    @Override
    public long solvePartTwo() {
        int totalTrueAnswers = 0;
        String combinedString = "";
        int peopleInGroup = 0;
        for (String s: values) {
            if (s.equals("")) {
                // if this is an empty string, count the number of true answers in the combined string
                // and add it to the running total
                totalTrueAnswers += countCombinedAnswers(combinedString, peopleInGroup);
                // clear the combined string and number of people in the group
                combinedString = "";
                peopleInGroup = 0;
            } else {
                combinedString = combinedString.concat(s);
                peopleInGroup++;
            }
        }
        // count up for the last set of strings
        totalTrueAnswers += countCombinedAnswers(combinedString, peopleInGroup);
        System.out.println("The total number of true answers given is: " + totalTrueAnswers);
        return totalTrueAnswers;
    }
}
