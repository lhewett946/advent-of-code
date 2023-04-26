package net.lsmith946.adventofcode.problems2015;

public class Lamp {

    private boolean lit;

    public Lamp() {
        this.lit = false;
    }

    public void turnOn() {
        this.lit = true;
    }

    public void turnOff() {
        this.lit = false;
    }

    public void toggle() {
        this.lit = !this.lit;
    }

    public boolean isLit() {
        return this.lit;
    }
}
