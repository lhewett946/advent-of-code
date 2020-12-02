package net.lsmith946.adventofcode;

import java.io.IOException;
import java.util.List;

public class Day2 implements Puzzle {

    List<String> values;

    public Day2() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day2_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 2 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        int validPasswords = 0;
        for (String s: values) {
            // decode the data from the input file
            String [] splitStrings = s.split(" ");
            String [] minMaxCount = splitStrings[0].split("-");
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
        System.out.println("--- PART ONE ---");
        System.out.println("The number of valid passwords is " + validPasswords);
        return validPasswords;
    }

    @Override
    public int solvePartTwo() {
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
        System.out.println("--- PART TWO ---");
        System.out.println("The number of valid passwords is " + validPasswords);
        return validPasswords;
    }
}
