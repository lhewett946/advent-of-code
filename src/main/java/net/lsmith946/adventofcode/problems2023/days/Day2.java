package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class Day2 implements Puzzle<Long> {

    List<String> values;
    public Day2() throws IOException, URISyntaxException, InterruptedException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList(2023, 2);
    }

    @Override
    public Long solvePartOne() {
        long sum = 0L;
        for (String game : values) {
            int redCubes = 0, blueCubes = 0, greenCubes = 0;
            int gameID = 0;
            boolean validGame = true;
            String[] seperateTurns = game.split(":|;");
            for (String turn: seperateTurns) {
                if (turn.contains("Game")) {
                    gameID = Integer.parseInt(turn.split(" ")[1]);
                }
                else {
                    String[] cubes = turn.split(",");
                    // extract the number of cubes of each colour
                    for (String cubeType : cubes) {
                        if (cubeType.contains("blue")) {
                            blueCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                        if (cubeType.contains("red")) {
                            redCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                        if (cubeType.contains("green")) {
                            greenCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                    }

                    // test against the known bag contents to see if it is possible
                    if (redCubes > 12 || greenCubes > 13 || blueCubes > 14) {
                        validGame = false;
                    }
                }
            }

            if (validGame) {
                sum += gameID;
            }
        }
        System.out.println("The sum of the possible game IDs is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        long totalPower = 0L;
        for (String game : values) {
            int redCubes = 0, blueCubes = 0, greenCubes = 0;
            int bagRedCubes = 0, bagBlueCubes = 0, bagGreenCubes = 0;
            int gamePower;
            String[] seperateTurns = game.split(":|;");
            for (String turn: seperateTurns) {
                if (!(turn.contains("Game")))  {
                    String[] cubes = turn.split(",");
                    // extract the number of cubes of each colour
                    for (String cubeType : cubes) {
                        if (cubeType.contains("blue")) {
                            blueCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                        if (cubeType.contains("red")) {
                            redCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                        if (cubeType.contains("green")) {
                            greenCubes = Integer.parseInt(cubeType.split(" ")[1]);
                        }
                    }

                    // test against the known bag contents and update them if needed
                    bagRedCubes = Math.max(bagRedCubes, redCubes);
                    bagBlueCubes= Math.max(bagBlueCubes, blueCubes);
                    bagGreenCubes= Math.max(bagGreenCubes, greenCubes);
                }
            }

            gamePower = bagRedCubes * bagBlueCubes * bagGreenCubes;
            totalPower += gamePower;
        }
        System.out.println("The total power of the possible game IDs is " + totalPower);
        return totalPower;
    }
}
