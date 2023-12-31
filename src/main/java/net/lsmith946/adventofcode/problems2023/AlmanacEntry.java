package net.lsmith946.adventofcode.problems2023;

public class AlmanacEntry {

    private long seed;
    private long range;
    private long soil;
    private long fertilizer;
    private long water;
    private long light;
    private long temperature;
    private long humidity;
    private long location;

    public AlmanacEntry(long seed, long range) {
        this.seed = seed;
        this.range = range;
    }

    public AlmanacEntry(AlmanacEntry original) {
        this.seed = original.seed;
        this.range = original.range;
        this.soil = original.soil;
        this.fertilizer = original.fertilizer;
        this.water = original.water;
        this.light = original.light;
        this.temperature = original.temperature;
        this.humidity = original.humidity;
        this.location = original.location;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public long getRange() {
        return range;
    }

    public void setRange(long range) {
        this.range = range;
    }

    public long getSoil() {
        return soil;
    }

    public void setSoil(long soil) {
        this.soil = soil;
    }

    public long getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(long fertilizer) {
        this.fertilizer = fertilizer;
    }

    public long getWater() {
        return water;
    }

    public void setWater(long water) {
        this.water = water;
    }

    public long getLight() {
        return light;
    }

    public void setLight(long light) {
        this.light = light;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }
}
