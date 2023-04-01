package net.lsmith946.adventofcode.problems2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PresentTest {

    @Test
    void calculateWrappingPaperNeeded() {
        Present present;
        present = new Present(2,3,4);
        Assertions.assertEquals(58, present.calculateWrappingPaperNeeded());

        present = new Present(3,4,2);
        Assertions.assertEquals(58, present.calculateWrappingPaperNeeded());
    }

    @Test
    void calculateRibbonLength() {
        Present present;
        present = new Present(2,3,4);
        Assertions.assertEquals(34, present.calculateRibbonLength());

        present = new Present(3,4,2);
        Assertions.assertEquals(34, present.calculateRibbonLength());
    }
}