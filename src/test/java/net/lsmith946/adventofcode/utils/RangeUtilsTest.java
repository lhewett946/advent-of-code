package net.lsmith946.adventofcode.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RangeUtilsTest {

    @Test
    void testFindOverlapStartEnd() {
        long overlapPoint = RangeUtils.findOverlapPoint(0, 20, 10, 25);
        Assertions.assertEquals(10, overlapPoint);

        overlapPoint = RangeUtils.findOverlapPoint(10, 25, 0, 20);
        Assertions.assertEquals(10, overlapPoint);

        overlapPoint = RangeUtils.findOverlapPoint(10, 50, 10, 20);
        Assertions.assertEquals(20, overlapPoint);

        overlapPoint = RangeUtils.findOverlapPoint(10, 50, 30, 50);
        Assertions.assertEquals(30, overlapPoint);
    }

    @Test
    void testOverlapDirection() {
        RangeUtils.RangeOverlapType overlapType = RangeUtils.overlapDirection(0, 20, 10, 25);
        Assertions.assertEquals(RangeUtils.RangeOverlapType.TOP, overlapType);

        overlapType = RangeUtils.overlapDirection(10, 25, 0, 20);
        Assertions.assertEquals(RangeUtils.RangeOverlapType.BOTTOM, overlapType);
    }

    @Test
    void testRange2InsideRange1() {
        Assertions.assertTrue(RangeUtils.range2InsideRange1(5, 20, 10, 15));
        Assertions.assertFalse(RangeUtils.range2InsideRange1(5, 20, 10, 25));
        Assertions.assertFalse(RangeUtils.range2InsideRange1(5, 20, 0, 15));
    }
}