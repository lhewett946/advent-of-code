package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.AlmanacEntry;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import net.lsmith946.adventofcode.utils.RangeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public final class Day5 implements Puzzle<Long> {

    List<String> values;

    private int findMapStart(String mapName) {
        int lineNumber = 0;
        while(!values.get(lineNumber).equals(mapName)) {
            lineNumber++;
        }
        return lineNumber+1;
    }

    private long determineSrcValue(String mapName, AlmanacEntry seed) {
        switch (mapName) {
            case "seed-to-soil map:" -> {
                return seed.getSeed();
            }
            case "soil-to-fertilizer map:" -> {
                return seed.getSoil();
            }
            case "fertilizer-to-water map:" -> {
                return seed.getFertilizer();
            }
            case "water-to-light map:" -> {
                return seed.getWater();
            }
            case "light-to-temperature map:" -> {
                return seed.getLight();
            }
            case "temperature-to-humidity map:" -> {
                return seed.getTemperature();
            }
            case "humidity-to-location map:" -> {
                return seed.getHumidity();
            }
        }
        throw new IllegalStateException("No matching map type found");
    }

    private void updateDestValue(String mapName, AlmanacEntry seed, long destValue) {
        switch (mapName) {
            case "seed-to-soil map:" -> {
                seed.setSoil(destValue);
            }
            case "soil-to-fertilizer map:" -> {
                seed.setFertilizer(destValue);
            }
            case "fertilizer-to-water map:" -> {
                seed.setWater(destValue);
            }
            case "water-to-light map:" -> {
                seed.setLight(destValue);
            }
            case "light-to-temperature map:" -> {
                seed.setTemperature(destValue);
            }
            case "temperature-to-humidity map:" -> {
                seed.setHumidity(destValue);
            }
            case "humidity-to-location map:" -> {
                seed.setLocation(destValue);
            }
            default -> throw new IllegalStateException("Unexpected value: " + mapName);
        }
    }

    private void processMapping(String mapName, List<AlmanacEntry> seedEntries) {
        for (AlmanacEntry seed : seedEntries) {
            boolean matchingRangeFound = false;
            int currentInputLine = findMapStart(mapName);
            long destValue = 0;
            long srcValue = determineSrcValue(mapName, seed);
            long seedRangeSize = seed.getRange();

            while (!values.get(currentInputLine).isEmpty() && currentInputLine != values.size()-1) {
                String[] mapEntry = StringUtils.split(values.get(currentInputLine));
                long destRangeStart = Long.parseLong(mapEntry[0]);
                long srcRangeStart = Long.parseLong(mapEntry[1]);
                long rangeSize = Long.parseLong(mapEntry[2]);

                if (RangeUtils.rangesFullyContained(srcRangeStart, srcRangeStart + rangeSize, srcValue, srcValue + seedRangeSize)) {
                    long distIntoRange = srcValue - srcRangeStart;
                    destValue = destRangeStart + distIntoRange;
                    matchingRangeFound = true;
                    break;
                }
                currentInputLine++;
            }

            if (!matchingRangeFound) {
                destValue = srcValue;
            }

            updateDestValue(mapName, seed, destValue);
        }
    }

    private long findLowestLocation(List<AlmanacEntry> seeds) {
        long lowestLocation = seeds.get(0).getLocation();
        for(AlmanacEntry seed : seeds) {
            if (seed.getLocation() < lowestLocation) {
                lowestLocation = seed.getLocation();
            }
        }
        return lowestLocation;
    }

    public Day5() throws IOException, URISyntaxException, InterruptedException {
        values = InputLoader.loadToStringList(2023, 5);
    }

    @Override
    public Long solvePartOne() {
        String[] seeds = StringUtils.split(values.get(0));
        List<AlmanacEntry> seedEntries = new ArrayList<>();
        for(String s : seeds) {
            if (!s.startsWith("seeds")) {
                AlmanacEntry entry = new AlmanacEntry(Long.parseLong(s), 1);
                seedEntries.add(entry);
            }
        }

        processMapping("seed-to-soil map:", seedEntries);
        processMapping("soil-to-fertilizer map:", seedEntries);
        processMapping("fertilizer-to-water map:", seedEntries);
        processMapping("water-to-light map:", seedEntries);
        processMapping("light-to-temperature map:", seedEntries);
        processMapping("temperature-to-humidity map:", seedEntries);
        processMapping("humidity-to-location map:", seedEntries);

        long lowestLocation = findLowestLocation(seedEntries);
        System.out.println("The lowest location corresponding to the initial seeds is " + lowestLocation);
        return lowestLocation;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
