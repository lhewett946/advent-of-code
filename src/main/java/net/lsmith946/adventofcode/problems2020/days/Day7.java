package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.problems2020.Bag;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7 implements Puzzle {

    List<String> values;
    List<Bag> bags;

    public Day7() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day7_input.txt");
        this.bags = new ArrayList<>();
        loadBags();
    }

    private void loadBags() {
        for (String s: values) {
            String [] nameContentsSplit = s.split("bags contain ");
            Bag newBag = new Bag(nameContentsSplit[0].trim());
            if (!nameContentsSplit[1].contains("no other bags")) {
                String[] individualContents = nameContentsSplit[1].split(", ");
                for (String content : individualContents) {
                    String [] contentsSplit =  content.split(" ");
                    String contentName = contentsSplit[1].concat(" ")
                                        .concat(contentsSplit[2]);
                    int contentQuantity = Integer.parseInt(contentsSplit[0]);
                    newBag.addToContents(contentName, contentQuantity);
                }
            }
            bags.add(newBag);
        }
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 7 ------");
        solvePartOne();
        solvePartTwo();
    }

    private List<Bag> getPossibleBags(String currentBagToCheck) {
        List<Bag> newPossibleBags = new ArrayList<>();
        for (Bag b : bags) {
            if (b.canContain(currentBagToCheck)) {
                newPossibleBags.add(b);
            }
        }
        return newPossibleBags;
    }

    @Override
    public int solvePartOne() {
        Set<Bag> possibleBags = new HashSet<>();
        // first find all the bags that could contain a shiny gold bag
        List<Bag> newPossibleBags = getPossibleBags("shiny gold");
        while(newPossibleBags.size() != 0) {
            Bag bagToCheck = newPossibleBags.get(0);
            newPossibleBags.remove(bagToCheck);
            // if the current bag that is being checked is not already in the set
            // add it to the set and check for any bags that could contain it
            if (!possibleBags.contains(bagToCheck)) {
                possibleBags.add(bagToCheck);
                newPossibleBags.addAll(getPossibleBags(bagToCheck.getBagColour()));
            }
        }
        System.out.println("The number of bag colours that can contain a shiny gold bag is: " + possibleBags.size());
        return possibleBags.size();
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
