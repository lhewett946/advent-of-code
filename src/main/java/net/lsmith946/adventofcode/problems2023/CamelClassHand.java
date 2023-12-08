package net.lsmith946.adventofcode.problems2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CamelClassHand implements Comparable<CamelClassHand> {

    protected char[] cardsInHand;
    private int    bid;
    protected CamelCardHandTypes handType;

    public char[] getCardsInHand() {
        return cardsInHand;
    }

    public int getBid() {
        return bid;
    }

    public CamelCardHandTypes getHandType() {
        return handType;
    }

    public CamelClassHand(String hand, int bid) {
        this.cardsInHand = hand.toCharArray();
        this.bid = bid;
        determineHandType();
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
        else if (cards.size() == 3) {
            // with 3 types of card, we could have the following hand types:
            // 3 of a kind
            // 2 pairs
            if (countChars.containsValue(3)) {
                handType = CamelCardHandTypes.KIND3;
            }
            else {
                handType = CamelCardHandTypes.PAIRS2;
            }
        }
        else if (cards.size() == 4) {
            // with 4 types of card, we must have one pair
            handType = CamelCardHandTypes.PAIRS1;
        }
        else {
            handType = CamelCardHandTypes.HIGH_CARD;
        }
    }

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
                return 11;
            }
            case 'T' -> {
                return 10;
            }
            default -> {
                return Integer.parseInt(String.valueOf(card));
            }
        }
    }

    @Override
    public int compareTo(CamelClassHand otherCard) {
        if (this.handType != otherCard.getHandType()) {
            // if the hands are of different types, then we only need to compare the hand types
            return this.handType.compareTo(otherCard.getHandType());
        }

        // otherwise we must start comparing the cards in turn
        // the easiest way to do this is to convert each card to its value and compare them as integers
        for(int i = 0; i < cardsInHand.length; i++) {
            if (cardToValue(this.cardsInHand[i]) != cardToValue(otherCard.getCardsInHand()[i])) {
                return Integer.compare(cardToValue(this.cardsInHand[i]), cardToValue(otherCard.getCardsInHand()[i]));
            }
        }
        throw new IllegalStateException("Unable to differentiate between the two hands!");
    }
}
