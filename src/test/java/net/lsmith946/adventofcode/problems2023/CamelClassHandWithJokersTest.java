package net.lsmith946.adventofcode.problems2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CamelClassHandWithJokersTest {

    @Test
    public void testDetermineHandType() {
        CamelClassHandWithJokers testCard = new CamelClassHandWithJokers("22222", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND5, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22223", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND4, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("2222J", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND5, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("JJJJ3", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND5, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22233", 1);
        Assertions.assertEquals(CamelCardHandTypes.FULL_HOUSE, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("JJJ33", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND5, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("222JJ", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND5, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22234", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND3, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("JJJ34", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND4, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("222J4", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND4, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22334", 1);
        Assertions.assertEquals(CamelCardHandTypes.PAIRS2, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("JJ334", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND4, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22JJ4", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND4, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("2233J", 1);
        Assertions.assertEquals(CamelCardHandTypes.FULL_HOUSE, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22345", 1);
        Assertions.assertEquals(CamelCardHandTypes.PAIRS1, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("JJ345", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND3, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("22J45", 1);
        Assertions.assertEquals(CamelCardHandTypes.KIND3, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("23456", 1);
        Assertions.assertEquals(CamelCardHandTypes.HIGH_CARD, testCard.getHandType());

        testCard = new CamelClassHandWithJokers("J3456", 1);
        Assertions.assertEquals(CamelCardHandTypes.PAIRS1, testCard.getHandType());
    }
}
