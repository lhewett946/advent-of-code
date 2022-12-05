package net.lsmith946.adventofcode.problems2022.days;

import net.lsmith946.adventofcode.problems2022.CraneMove;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

public class Day5 implements Puzzle<String> {

    List <String> values;
    List<Stack<Character>> stacks;
    List<CraneMove> moves;

    public Day5() throws IOException {
        values = InputLoader.loadToStringList("/2022/day5_input.txt");
        decodeInput();
    }

    private void decodeInput() {
        // start by populating the stacks
        int inputLineNumber = 0;

        String inputString = "dummy"; // dummy the first string to ensure we enter the while loop
        while (!inputString.isEmpty()) {
            inputString = values.get(inputLineNumber);
            inputLineNumber++;
        }
        List<String> stackContents = values.subList(0, inputLineNumber-1);
        Collections.reverse(stackContents);

        // first line tells you how many stacks there are
        int numberOfStacks = stackContents.get(0).split(" {3}").length;
        stacks = new ArrayList<>();
        for(int stack = 0; stack < numberOfStacks; stack++) {
            stacks.add(new Stack<>());
        }

        // subsequent lines tell you which crates are in each stack
        for(int layer = 1; layer < stackContents.size(); layer++) {
            char[] layerContents = StringUtils.rightPad(stackContents.get(layer), numberOfStacks*4, " ").toCharArray();
            for(int stack = 0; stack < numberOfStacks; stack++) {
                char crateName = layerContents[(stack*4)+1];
                if (crateName != ' ') {
                    stacks.get(stack).add(crateName);
                }
            }
        }

        // then decode the moves
        moves = new ArrayList<>();
        while(inputLineNumber < values.size()) {
            String[] order = values.get(inputLineNumber).split(" ");
            CraneMove move = new CraneMove(Integer.parseInt(order[1]), Integer.parseInt(order[3]), Integer.parseInt(order[5]));
            moves.add(move);
            inputLineNumber++;
        }
    }

    @Override
    public String solvePartOne() {
        // process the moves
        for(CraneMove move : moves) {
            char crateMoving;
            for(int count = 0; count < move.cratesToMove; count++) {
                crateMoving = stacks.get(move.fromStack-1).pop();
                stacks.get(move.toStack-1).push(crateMoving);
            }
        }

        // build the string from the top crate in each stack
        StringBuilder topCrates = new StringBuilder();
        for(Stack<Character> stack : stacks) {
            topCrates.append(stack.peek());
        }
        System.out.println("The message to pass to the elves is " + topCrates);
        return topCrates.toString();
    }

    @Override
    public String solvePartTwo() {
        return "";
    }
}
