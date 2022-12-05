package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day2 implements Puzzle<Integer> {

    List<String> values;

    public Day2() throws IOException {
        this.values = InputLoader.loadToStringList("/2020/day2_input.txt");
    }

    @Override
    public Integer solvePartOne() {
        int validPasswords = 0;
        for (String s : values) {
            // decode the data from the input file
            String[] splitStrings = s.split(" ");
            String[] minMaxCount = splitStrings[0].split("-");
            int minCount = Integer.parseInt(minMaxCount[0]);
            int maxCount = Integer.parseInt(minMaxCount[1]);
            char letter = splitStrings[1].charAt(0);
            char[] password = splitStrings[2].toCharArray();

            // check password validity
            int letterCount = 0;
            for (char c: password) {
                if (c == letter) {
                    letterCount++;
                }
            }
            if (letterCount >= minCount && letterCount <= maxCount) {
                validPasswords++;
            }
        }
        System.out.println("The number of valid passwords is " + validPasswords);
        return validPasswords;
    }

    @Override
    public Integer solvePartTwo() {
        int validPasswords = 0;
        for (String s: values) {
            // decode the data from the input file
            String [] splitStrings = s.split(" ");
            String [] minMaxCount = splitStrings[0].split("-");
            int firstPosition = Integer.parseInt(minMaxCount[0]) - 1;
            int secondPosition = Integer.parseInt(minMaxCount[1]) - 1;
            char letter = splitStrings[1].charAt(0);
            char[] password = splitStrings[2].toCharArray();

            // check password validity
            if (password[firstPosition] == letter ^ password[secondPosition] == letter) {
                validPasswords++;
            }
        }
        System.out.println("The number of valid passwords is " + validPasswords);
        return validPasswords;
    }
}
