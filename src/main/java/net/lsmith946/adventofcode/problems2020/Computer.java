package net.lsmith946.adventofcode.problems2020;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    List<Instruction> instructions;
    int accumulator;

    public Computer(List<Instruction> instructions) {
        this.instructions = instructions;
        this.accumulator = 0;
    }

    public int getAccumulator() {
        return accumulator;
    }

    // function to execute the instructions loaded to the computer
    // returns true if the instructions complete and false if an infinite loop is detected
    public boolean executeInstructions() {
        int instructionPointer = 0;
        Set<Integer> instructionPositionsExecuted = new HashSet<>();
        while (!instructionPositionsExecuted.contains(instructionPointer)) {
            instructionPositionsExecuted.add(instructionPointer);
            Instruction currentInstruction = instructions.get(instructionPointer);
            switch (currentInstruction.getOpcode()) {
                case "nop" -> {
                    // nop has no effect, but increase the instruction pointer
                    instructionPointer++;
                }
                case "acc" -> {
                    // acc adds the argument to the accumulator and increases the instruction pointer
                    accumulator += currentInstruction.getArgument();
                    instructionPointer++;
                }
                case "jmp" -> {
                    // jmp moves the instruction pointer by the value given as the argument
                    instructionPointer += currentInstruction.getArgument();
                }
                default -> throw new IllegalStateException("Unexpected opcode: " + currentInstruction.getOpcode());
            }
        }
        return false;
    }
}
