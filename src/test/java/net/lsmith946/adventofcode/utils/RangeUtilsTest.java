package net.lsmith946.adventofcode.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RangeUtilsTest {

    @Test
    void testFindOverlapStartEnd() {
        long overlapPoint = RangeUtils.findOverlapStartEnd(0, 20, 10, 25);
        Assertions.assertEquals(10, overlapPoint);

        overlapPoint = RangeUtils.findOverlapStartEnd(10, 25, 0, 20);
        Assertions.assertEquals(10, overlapPoint);
    }

    @Test
    void testOverlapDirection() {
        RangeUtils.RangeOverlapType overlapType = RangeUtils.overlapDirection(0, 20, 10, 25);
        Assertions.assertEquals(RangeUtils.RangeOverlapType.TOP, overlapType);

        overlapType = RangeUtils.overlapDirection(10, 25, 0, 20);
        Assertions.assertEquals(RangeUtils.RangeOverlapType.BOTTOM, overlapType);
    }
}