package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day8 implements Puzzle<Long> {

    List<String> input;

    public Day8() throws IOException {
        this.input = InputLoader.loadToStringList("/2015/day8_input.txt");
    }

    @Override
    public Long solvePartOne() {
        long codeCharacters = 0;
        long memCharacters = 0;
        for(String s : input) {
            // code characters are just the number of characters in the string
            codeCharacters += s.length();
            char[] stringContents = s.toCharArray();
            for(int index = 0; index < stringContents.length; index++) {
                if (stringContents[index] == '\\') {
                    // if the character is an escape character, decode it separately
                    if (stringContents[index+1] == '\"' || stringContents[index+1] == '\\') {
                        memCharacters++;
                        index++; // increment index to prevent processing the second character again
                    } else if (stringContents[index+1] == 'x') {
                        memCharacters++; // for the single ASCII character
                        index += 3; // advance the index by 3 to skip the additional characters which are part of the ASCII one
                    }
                } else if (stringContents[index] != '\"' && stringContents[index] != ' ') {
                    // if the character is anything but an escape character or a quote, it is a single character
                    memCharacters++;
                }
            }
        }
        long difference = codeCharacters - memCharacters;
        System.out.println("The difference between the code characters and the memory characters is " + difference);
        return difference;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
