package net.lsmith946.adventofcode.problems2023;

public class AlmanacEntry {

    private long seed;
    private long soil;
    private long fertilizer;
    private long water;
    private long light;
    private long temperature;
    private long humidity;
    private long location;

    public AlmanacEntry(long seed) {
        this.seed = seed;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
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
