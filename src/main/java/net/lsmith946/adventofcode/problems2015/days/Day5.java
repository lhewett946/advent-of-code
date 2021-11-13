package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Day5 implements Puzzle {

    List<String> input;

    public Day5() throws IOException {
        InputLoader il = new InputLoader();
        this.input = il.loadToStringList("/2015/day5_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 5 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        long niceStrings = 0;
        for(String s : input) {
            int vowelsInString = StringUtils.countMatches(s, 'a') +
                    StringUtils.countMatches(s, 'e') +
                    StringUtils.countMatches(s, 'i') +
                    StringUtils.countMatches(s, 'o') +
                    StringUtils.countMatches(s, 'u');
            if (vowelsInString < 3) continue;

            boolean doubleLetterFound = false;
            for(int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    doubleLetterFound = true;
                    break;
                }
            }
            if (!doubleLetterFound) continue;

            if (s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy")) continue;

            // increment number of nice strings if all checks pass
            niceStrings++;
        }
        System.out.println("There are " + niceStrings + " nice strings.");
        return niceStrings;
    }

    @Override
    public long solvePartTwo() {
        long niceStrings = 0;
        for(String s : input) {
            boolean repeatedPairFound = false;
            for(int i = 0; i < s.length()-1; i++) {
                String pair = s.substring(i, i+2);
                String stripCurrentPair = s.replaceFirst(pair, "  ");
                if (StringUtils.countMatches(stripCurrentPair, pair) != 0) {
                    repeatedPairFound = true;
                    break;
                }
            }

            if (!repeatedPairFound) continue;

            boolean repeatOneLetterBetween = false;
            for(int i = 0; i < s.length()-2; i++) {
                if (s.charAt(i) == s.charAt(i+2)) {
                    repeatOneLetterBetween = true;
                    break;
                }
            }
            if (!repeatOneLetterBetween) continue;

            // increment number of nice strings if all checks pass
            niceStrings++;
        }
        System.out.println("There are " + niceStrings + " nice strings.");
        return niceStrings;
    }
}
