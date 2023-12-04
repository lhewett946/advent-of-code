package net.lsmith946.adventofcode.problems2023;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Scratchcard {

    private List<Integer> winningNumbers;
    private List<Integer> cardNumbers;

    public Scratchcard(String str) {
        winningNumbers = new ArrayList<>();
        cardNumbers = new ArrayList<>();
        String[] splitString = str.split("[|:]");
        String[] winningNumbersStr = StringUtils.split(splitString[1].trim());
        String[] cardNumbersStr = StringUtils.split(splitString[2].trim());
        for(String winNum : winningNumbersStr) {
            winningNumbers.add(Integer.parseInt(winNum));
        }
        for(String winNum : cardNumbersStr) {
            cardNumbers.add(Integer.parseInt(winNum));
        }
    }

    public long calculateScore() {
        Set<Integer> matchingNumbers = new HashSet<>();
        matchingNumbers.addAll(cardNumbers);
        matchingNumbers.retainAll(winningNumbers);
        if (matchingNumbers.size() != 0) {
            return (long) Math.pow(2, matchingNumbers.size() - 1);
        }
        else {
            return 0;
        }
    }

    public long getNumberOfMatches() {
        Set<Integer> matchingNumbers = new HashSet<>();
        matchingNumbers.addAll(cardNumbers);
        matchingNumbers.retainAll(winningNumbers);
        return matchingNumbers.size();
    }
}
