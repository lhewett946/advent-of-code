package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 implements Puzzle {

    enum Moves { ROCK, PAPER, SCISSORS }

    private List<String> values;

    public Day3() throws IOException {
        this.values = InputLoader.loadToStringList("/2022/day3_input.txt");
    }

    private long convertToPriorityValue(Character item) {
        long priority = 0;
        if (item.equals(Character.toUpperCase(item))) {
            priority = 26;
        }
        switch(Character.toUpperCase(item)) {
            case 'A' -> priority += 1;
            case 'B' -> priority += 2;
            case 'C' -> priority += 3;
            case 'D' -> priority += 4;
            case 'E' -> priority += 5;
            case 'F' -> priority += 6;
            case 'G' -> priority += 7;
            case 'H' -> priority += 8;
            case 'I' -> priority += 9;
            case 'J' -> priority += 10;
            case 'K' -> priority += 11;
            case 'L' -> priority += 12;
            case 'M' -> priority += 13;
            case 'N' -> priority += 14;
            case 'O' -> priority += 15;
            case 'P' -> priority += 16;
            case 'Q' -> priority += 17;
            case 'R' -> priority += 18;
            case 'S' -> priority += 19;
            case 'T' -> priority += 20;
            case 'U' -> priority += 21;
            case 'V' -> priority += 22;
            case 'W' -> priority += 23;
            case 'X' -> priority += 24;
            case 'Y' -> priority += 25;
            case 'Z' -> priority += 26;
        }
        return priority;
    }

    @Override
    public long solvePartOne() {
        long prioritiesSum = 0;
        // find the item that exists in both compartments of the rucksack
        for(String s : values) {
            char sharedItem = 0;
            String firstCompartment = s.substring(0, (s.length()/2));
            String secondCompartment = s.substring(s.length()/2);
            // load the items in the first compartment into the set
            Set<Character> firstCompartmentItems = new HashSet<>();
            for(int i = 0; i < firstCompartment.length(); i++) {
                firstCompartmentItems.add(firstCompartment.charAt(i));
            }

            // check the items in the second compartment to see if they are already in the first compartment
            for(int i = 0; i < secondCompartment.length(); i++) {
                if (firstCompartmentItems.contains(secondCompartment.charAt(i))) {
                    sharedItem = secondCompartment.charAt(i);
                    break; // break on first match since we know only one item is common
                }
            }

            prioritiesSum += convertToPriorityValue(sharedItem);
        }
        System.out.println("The sum of the priorities of all the items is " + prioritiesSum);
        return prioritiesSum;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
