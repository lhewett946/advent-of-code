package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.problems2020.Computer;
import net.lsmith946.adventofcode.problems2020.Instruction;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day8 implements Puzzle {

    List<String> values;
    List<Instruction> instructions;

    public Day8() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/2020/day8_input.txt");
        this.instructions = new ArrayList<>();
        loadInstructions();
    }

    private void loadInstructions() {
        for (String s : values) {
            String[] instructionFields = s.split(" ");
            Instruction nextInstruction = new Instruction(instructionFields[0], Integer.parseInt(instructionFields[1]));
            instructions.add(nextInstruction);
        }
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 8 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        Computer comp = new Computer(instructions);
        comp.executeInstructions();
        // when the instruction pointer is a value which has been seen before
        // that is the start of the infinite loop
        // as requested, return the value in the accumulator
        System.out.println("The value of the accumulator when the instruction is executed for the second time is: " + comp.getAccumulator());
        return comp.getAccumulator();
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
