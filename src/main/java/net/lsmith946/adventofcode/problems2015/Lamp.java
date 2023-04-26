package net.lsmith946.adventofcode.problems2015;

public class Lamp {

    private boolean lit;
    private int brightness;

    public Lamp() {
        this.lit = false;
        this.brightness = 0;
    }

    public void turnOn() {
        this.lit = true;
        this.brightness++;
    }

    public void turnOff() {
        this.lit = false;
        this.brightness--;
        if (this.brightness < 0) {
            brightness = 0;
        }
    }

    public void toggle() {
        this.lit = !this.lit;
        this.brightness += 2;
    }

    public boolean isLit() {
        return this.lit;
    }

    public int getBrightness() {
        return brightness;
    }
}
