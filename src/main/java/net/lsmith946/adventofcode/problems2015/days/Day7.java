package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.problems2015.Wire;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.*;

public class Day7 implements Puzzle<Long> {

    List<String> input;
    Map<String,Wire> wires = new HashMap<>();

    public Day7() throws IOException {
        this.input = InputLoader.loadToStringList("/2015/day7_input.txt");
    }

    private long getOperandValue(String operand) {
        if (operand.matches("[0-9]+")) {
            // if the operand has digits, return the value of the operand
            return Long.parseLong(operand);
        } else {
            // otherwise, read the wire to find out its value
            return wires.get(operand).getSignalValue();
        }
    }

    private void processInstructions() {
        LinkedList<String> unprocessed = new LinkedList<>(input);

        do {
            String s = unprocessed.remove(0);
            String[] substrings = s.split("\\s+|\\s->\\s");
            String wireID = substrings[substrings.length - 1];
            long wireValue = 0;

            try {
                if (s.contains("NOT")) {
                    // not is a special case as it has only one operand
                    long inputValue = getOperandValue(substrings[1]);
                    wireValue = ~(inputValue);
                } else if (s.contains("SHIFT") || s.contains("AND") || s.contains("OR")) {
                    long operand1 = getOperandValue(substrings[0]);
                    long operand2 = getOperandValue(substrings[2]);
                    switch (substrings[1]) {
                        case "LSHIFT" -> wireValue = operand1 << operand2;
                        case "RSHIFT" -> wireValue = operand1 >> operand2;
                        case "AND" -> wireValue = operand1 & operand2;
                        case "OR" -> wireValue = operand1 | operand2;
                    }
                } else {
                    // direct assignment from operand to the wire
                    wireValue = getOperandValue(substrings[0]);
                }
            }
            catch (NullPointerException e) {
                // if we encountered a null pointer exception, then we must not have the values
                // we need to evaluate this instruction yet, so we must re-add it to the input
                unprocessed.addLast(s);
                continue;
            }

            // add the wire into the list, as long as it doesn't already exist
            if (!wires.containsKey(wireID)) {
                Wire newWire = new Wire(wireValue);
                wires.put(wireID, newWire);
            }
        } while(!unprocessed.isEmpty());
    }

    @Override
    public Long solvePartOne() {
        processInstructions();
        System.out.println("The signal value on wire a is " + wires.get("a").getSignalValue());
        return wires.get("a").getSignalValue();
    }

    @Override
    public Long solvePartTwo() {
        // take the value on wire a from part 1
        long wireValue = solvePartOne();

        // reset all the wires
        wires.clear();

        // override wire b with the value from part 1
        Wire b = new Wire(wireValue);
        wires.put("b", b);

        // rerun the circuit again
        processInstructions();

        System.out.println("The signal value on wire a is " + wires.get("a").getSignalValue());
        return wires.get("a").getSignalValue();
    }
}
