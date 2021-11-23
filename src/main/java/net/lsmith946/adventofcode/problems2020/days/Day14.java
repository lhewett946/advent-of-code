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
        instructions = InputLoader.loadToStringList("/2020/day14_input.txt");
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
                StringBuilder valueToWrite = new StringBuilder(StringUtils.leftPad(Long.toString(value, 2), 36, "0"));

                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) != 'X') {
                        valueToWrite.setCharAt(i, mask.charAt(i));
                    }
                }
                memoryContents.put(address, Long.parseLong(valueToWrite.toString(), 2));
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
                StringBuilder addressWithFloating = new StringBuilder(StringUtils.leftPad(Long.toString(address, 2), 36, "0"));

                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) != '0') {
                        addressWithFloating.setCharAt(i, mask.charAt(i));
                    }
                }

                // generate all possible addresses based on the floating bits
                int numberOfFloatingBits = StringUtils.countMatches(addressWithFloating.toString(), "X");
                for (long i = 0; i < Math.pow(2, numberOfFloatingBits); i++) {
                    StringBuilder addressToWrite = new StringBuilder(addressWithFloating);
                    for (int j = 0; j < numberOfFloatingBits; j++) {
                        String iInBinary = StringUtils.leftPad(Long.toBinaryString(i), numberOfFloatingBits, "0");
                        addressToWrite.setCharAt(addressToWrite.lastIndexOf("X"), iInBinary.charAt(j));
                    }
                    memoryContents.put(Long.parseLong(addressToWrite.toString(), 2), value);
                }
            }
        }
        long sum = 0;
        for (Long value : memoryContents.values()) {
            sum += value;
        }
        System.out.println("The sum of the memory contents at the end of the program is:" + sum);
        return sum;
    }
}
