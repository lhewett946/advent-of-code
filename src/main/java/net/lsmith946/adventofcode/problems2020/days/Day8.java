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
        System.out.println("The value of the accumulator just before an instruction is executed for the second time is: " + comp.getAccumulator());
        return comp.getAccumulator();
    }

    @Override
    public long solvePartTwo() {
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).getOpcode().equals("nop") || instructions.get(i).getOpcode().equals("jmp")) {
                List<Instruction> modifiedInstructions = new ArrayList<>(instructions.size());
                // make sure to take a copy of the list
                // otherwise due to objects passing by reference we will modify the original instructions
                for (Instruction instr : instructions) {
                    Instruction copiedByValue = instr.copyByValue();
                    modifiedInstructions.add(copiedByValue);
                }
                Instruction instructionToModify = modifiedInstructions.get(i);
                if (instructionToModify.getOpcode().equals("nop")) {
                    instructionToModify.setOpcode("jmp");
                } else {
                    instructionToModify.setOpcode("nop");
                }
                modifiedInstructions.set(i, instructionToModify);
                Computer comp = new Computer(modifiedInstructions);
                if (comp.executeInstructions()) {
                    // if the computer executes the instructions successfully
                    // get and return the accumulator
                    System.out.println("The value of the accumulator at the end of the program is: " + comp.getAccumulator());
                    return comp.getAccumulator();
                }
            }
        }
        return -1;
    }
}
