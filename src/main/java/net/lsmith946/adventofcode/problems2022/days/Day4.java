package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day4 implements Puzzle {

    List <String> values;

    public Day4() throws IOException {
        values = InputLoader.loadToStringList("/2022/day4_input.txt");
    }

    @Override
    public long solvePartOne() {
        long overlappedPairs = 0;
        for(String s : values) {
            String[] elfAssignments = s.split("[,\\-]");
            int [] zones = new int[4];
            for(int i =0; i < 4; i++) {
                zones[i] = Integer.parseInt(elfAssignments[i]);
            }

            if (((zones[0] <= zones[2]) && (zones[1] >= zones[3])) || ((zones[2] <= zones[0]) && (zones[3] >= zones[1]))) {
                overlappedPairs++;
            }
        }
        System.out.println("The number of pairs where one elf's zones are fully covered by the other is " + overlappedPairs);
        return overlappedPairs;
    }

    @Override
    public long solvePartTwo() {
        long overlappedPairs = 0;
        for(String s : values) {
            String[] elfAssignments = s.split("[,\\-]");
            int [] zones = new int[4];
            for(int i =0; i < 4; i++) {
                zones[i] = Integer.parseInt(elfAssignments[i]);
            }

            if (((zones[0] <= zones[2]) && (zones[1] >= zones[2])) || ((zones[0] <= zones[3]) && (zones[1] >= zones[3])) ||
                    ((zones[2] <= zones[0]) && (zones[3] >= zones[0])) || ((zones[2] <= zones[1]) && (zones[3] >= zones[1]))) {
                overlappedPairs++;
            }
        }
        System.out.println("The number of pairs where one elf's zones are overlapping is " + overlappedPairs);
        return overlappedPairs;
    }
}
