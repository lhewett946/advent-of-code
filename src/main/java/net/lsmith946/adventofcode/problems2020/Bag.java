package net.lsmith946.adventofcode.problems2020;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private String bagColour;
    private Map<String, Integer> bagContents;

    public Bag(String bagColour) {
        this.bagColour = bagColour;
        bagContents = new HashMap<>();
    }

    public String getBagColour() {
        return bagColour;
    }

    public void addToContents(String bagName, int count) {
        bagContents.put(bagName, count);
    }

    public boolean canContain(String bagName) {
        return bagContents.containsKey(bagName);
    }
}
