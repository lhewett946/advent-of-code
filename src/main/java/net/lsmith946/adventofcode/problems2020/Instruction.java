package net.lsmith946.adventofcode.problems2020;

public class Instruction {

    String opcode;
    int argument;

    public Instruction(String opcode, int argument) {
        this.opcode = opcode;
        this.argument = argument;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getOpcode() {
        return opcode;
    }

    public int getArgument() {
        return argument;
    }

    public Instruction copyByValue() {
        Instruction newInstruction = new Instruction(this.opcode, this.argument);
        return newInstruction;
    }
}
