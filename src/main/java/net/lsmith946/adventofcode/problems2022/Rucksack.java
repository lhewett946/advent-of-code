package net.lsmith946.adventofcode.problems2022;

import net.lsmith946.adventofcode.utils.FormatConverter;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Rucksack {

    private String contents;

    public Rucksack(String contents) {
        this.contents = contents;
    }

    public char findItemInBothCompartments() {
        String firstCompartment = contents.substring(0, (contents.length()/2));
        String secondCompartment = contents.substring(contents.length()/2);
        // load the items in the first compartment into the set
        Set<Character> firstCompartmentItems = FormatConverter.stringToCharSet(firstCompartment);

        // check the items in the second compartment to see if they are already in the first compartment
        for(int i = 0; i < secondCompartment.length(); i++) {
            if (firstCompartmentItems.contains(secondCompartment.charAt(i))) {
                return secondCompartment.charAt(i);
            }
        }

        // if we get here, we didn't find a common item for some reason, and we should have done
        // so throw an exception and complain about this
        throw new IllegalStateException("Did not find any common item in both compartments of the rucksack!");
    }
}
