package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Lamp;
import net.lsmith946.adventofcode.problems2015.Santa;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.List;

public class Day6 implements Puzzle<Long> {

    List<String> input;

    public Day6() throws IOException {
        this.input = InputLoader.loadToStringList("/2015/day6_input.txt");
    }

    @Override
    public Long solvePartOne() {
        Lamp[][] lamps = new Lamp[1000][1000];

        // create all the lamps
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                lamps[i][j] = new Lamp();
            }
        }

        // follow Santa's instructions to set up the lamps
        for (String instruction: input) {
            String[] instructionFields = instruction.split("\\s|,");
            int instructionLength = instructionFields.length;
            Grid2DCoordinates startPosition = new Grid2DCoordinates(Integer.parseInt(instructionFields[instructionLength-5]), Integer.parseInt(instructionFields[instructionLength-4]));
            Grid2DCoordinates finishPosition = new Grid2DCoordinates(Integer.parseInt(instructionFields[instructionLength-2]), Integer.parseInt(instructionFields[instructionLength-1]));
            for(int x = startPosition.getX(); x <= finishPosition.getX(); x++) {
                for (int y = startPosition.getY(); y <= finishPosition.getY(); y++) {
                    if (instructionFields[0].contains("toggle")) {
                        // toggle the lamps in the range
                        lamps[x][y].toggle();
                    } else {
                        // lamps can be turned on or off
                        if (instructionFields[1].contains("on")) {
                            lamps[x][y].turnOn();
                        } else {
                            lamps[x][y].turnOff();
                        }
                    }
                }
            }
        }

        // count how many lamps are turned on
        Long lampsOn = 0L;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if (lamps[i][j].isLit()) {
                    lampsOn++;
                }
            }
        }

        System.out.println("The number of lamps that are lit is " + lampsOn);
        return lampsOn;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
