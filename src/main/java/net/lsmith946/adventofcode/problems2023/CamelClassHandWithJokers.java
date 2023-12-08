package net.lsmith946.adventofcode.problems2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CamelClassHandWithJokers extends CamelClassHand {

    public CamelClassHandWithJokers(String hand, int bid) {
        super(hand, bid);
    }

    protected void determineHandType() {
        Map<Character, Integer> countChars = new HashMap<>();
        for(Character c : cardsInHand) {
            if (countChars.containsKey(c)) {
                countChars.put(c, countChars.get(c)+1);
            }
            else {
                countChars.put(c, 1);
            }
        }

        Set<Character> cards = countChars.keySet();

        if(cards.size() == 1) {
            // if there is only 1 type of card, we must have a 5 of a kind hand
            handType = CamelCardHandTypes.KIND5;
        }
        else if (cards.size() == 2) {
            if (countChars.containsKey('J')) {
                // if we have two types of cards and one of them is Jokers, we can make our hand 5 of a kind
                handType = CamelCardHandTypes.KIND5;
            }
            else {
                // with 2 types of card, we could have the following hand types:
                // 4 of a kind
                // full house
                if (countChars.containsValue(4)) {
                    handType = CamelCardHandTypes.KIND4;
                }
                else {
                    handType = CamelCardHandTypes.FULL_HOUSE;
                }
            }
        }
        else if (cards.size() == 3) {
            // with 3 types of card, we could have the following hand types:
            // 3 of a kind
            // 2 pairs
            if (countChars.containsValue(3)) {
                handType = CamelCardHandTypes.KIND3;
                // if we have three of a kind and one Joker, we can make our hand 4 of a kind
                if (countChars.containsKey('J')) {
                    handType = CamelCardHandTypes.KIND4;
                }
            }
            else {
                handType = CamelCardHandTypes.PAIRS2;
                if (countChars.containsKey('J')) {
                    // if one of the pairs is a pair of Jokers, we can make our hand 4 of a kind
                    if (countChars.get('J') == 2) {
                        handType = CamelCardHandTypes.KIND4;
                    }
                    // otherwise we have only one Joker, which means we can make a full house
                    else {
                        handType = CamelCardHandTypes.FULL_HOUSE;
                    }
                }
            }
        }
        else if (cards.size() == 4) {
            // with 4 types of card, we must have one pair
            handType = CamelCardHandTypes.PAIRS1;
            if (countChars.containsKey('J')) {
                // if we have one pair, we can either use 1 Joker to turn the pair into a 3, or a pair of Jokers
                // to turn one of the single cards into a 3
                handType = CamelCardHandTypes.KIND3;
            }
        }
        else {
            handType = CamelCardHandTypes.HIGH_CARD;
            if (countChars.containsKey('J')) {
                // if all the cards are unique but one of them is a Joker, it can be used to make a pair
                handType = CamelCardHandTypes.PAIRS1;
            }
        }
    }

    @Override
    protected int cardToValue(char card) {
        switch(card) {
            case 'A' -> {
                return 14;
            }
            case 'K' -> {
                return 13;
            }
            case 'Q' -> {
                return 12;
            }
            case 'J' -> {
                // J now represents a Joker and has the lowest value
                return 1;
            }
            case 'T' -> {
                return 10;
            }
            default -> {
                return Integer.parseInt(String.valueOf(card));
            }
        }
    }
}
