package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day1 implements Puzzle<Long> {

    List<String> values;

    public Day1() throws IOException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList("/2023/day1_input.txt");
    }

    private String toDigits (String str) {
        return switch (str) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> str;
        };
    }

    @Override
    public Long solvePartOne() {
        Long sum = 0L;
        for(String s : values) {
            String onlyDigits = s.replaceAll("[^0-9]", "");
            String selectedDigits = String.valueOf(onlyDigits.charAt(0)) + String.valueOf(onlyDigits.charAt(onlyDigits.length()-1));
            sum += Long.parseLong(selectedDigits);
        }
        System.out.println("The sum of all the calibration values is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        Long sum = 0L;
        Pattern findThese = Pattern.compile("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        for(String s : values) {
            String processingString = s;
            String selectedDigits = "";
            String firstDigit = "", lastDigit = "";
            while(!processingString.isEmpty()) {
                Matcher matcher = findThese.matcher(processingString);
                // get the first and last numbers
                if(matcher.find()) {
                    if (firstDigit.isEmpty()) {
                        firstDigit = toDigits(matcher.group(0));
                    }
                    lastDigit = toDigits(matcher.group(0));
                }
                else break;
                // strip the first character off the string
                processingString = processingString.substring(1);
            }
            selectedDigits = firstDigit + lastDigit;
            sum += Long.parseLong(selectedDigits);
        }
        System.out.println("The sum of all the calibration values is " + sum);
        return sum;
    }
}
