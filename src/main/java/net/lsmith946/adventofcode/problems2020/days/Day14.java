package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 implements Puzzle {

    List<String> instructions;

    public Day14() throws IOException {
        InputLoader il = new InputLoader();
        instructions = il.loadToStringList("/2020/day14_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 14 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        Map<Long, Long> memoryContents = new HashMap<>();
        long address;
        String mask = "";
        for (String instruction : instructions) {
            String[] instructionSplit = instruction.split(" = ");
            if (instructionSplit[0].equals("mask")) {
                mask = instructionSplit[1];
            } else {
                address = Long.parseLong(instructionSplit[0].replace("[", "")
                        .replace("]", "")
                        .replace("mem", ""));
                long value = Long.parseLong(instructionSplit[1]);
                StringBuilder valueToWrite = new StringBuilder(StringUtils.leftPad(Long.toString(value, 2), 36));

                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) != 'X') {
                        valueToWrite.setCharAt(i, mask.charAt(i));
                    }
                }
                memoryContents.put(address, Long.parseLong(valueToWrite.toString().replace(" ", "0"), 2));
            }
        }
        long sum = 0;
        for (Long value : memoryContents.values()) {
            sum += value;
        }
        System.out.println("The sum of the memory contents at the end of the program is:" + sum);
        return sum;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
