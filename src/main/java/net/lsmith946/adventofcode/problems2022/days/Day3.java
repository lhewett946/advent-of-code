package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.problems2022.Rucksack;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day3 implements Puzzle {

    enum Moves { ROCK, PAPER, SCISSORS }

    private List<String> values;
    private List<Rucksack> sacks;

    public Day3() throws IOException {
        this.values = InputLoader.loadToStringList("/2022/day3_input.txt");
        sacks = new ArrayList<>();
        for(String s : values) {
            Rucksack sack = new Rucksack(s);
            sacks.add(sack);
        }
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
        for(Rucksack sack : sacks) {
            char sharedItem = sack.findItemInBothCompartments();
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
