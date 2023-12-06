package net.lsmith946.adventofcode.utils;

public class RangeUtils {

    public enum RangeOverlapType { TOP, BOTTOM };

    /**
     * This function checks two ranges to see if they overlap with one another
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return true if the ranges overlap, false if they do not
     */
    public static boolean rangesOverlap(int startRange1, int endRange1, int startRange2, int endRange2) {
        return ((startRange1 >= startRange2) && (startRange1 <= endRange2)) ||
                ((endRange1 >= startRange2) && (endRange1 <= endRange2)) ||
                ((startRange2 >= startRange1) && (startRange2 <= endRange1)) ||
                ((endRange2 >= startRange1) && (endRange2 <= endRange1));
    }

    /**
     * This function checks two ranges to see if they overlap with one another
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return true if the ranges overlap, false if they do not
     */
    public static boolean rangesOverlap(long startRange1, long endRange1, long startRange2, long endRange2) {
        return ((startRange1 >= startRange2) && (startRange1 <= endRange2)) ||
                ((endRange1 >= startRange2) && (endRange1 <= endRange2)) ||
                ((startRange2 >= startRange1) && (startRange2 <= endRange1)) ||
                ((endRange2 >= startRange1) && (endRange2 <= endRange1));
    }

    /**
     * This function checks two ranges to see if one of the ranges is fully contained within the other
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return true if one of the ranges is fully contained within the other, false otherwise
     */
    public static boolean rangesFullyContained(int startRange1, int endRange1, int startRange2, int endRange2) {
        return (((startRange1 <= startRange2) && (endRange1 >= endRange2)) ||
                ((startRange2 <= startRange1) && (endRange2 >= endRange1)));
    }

    /**
     * This function checks two ranges to see if one of the ranges is fully contained within the other
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return true if one of the ranges is fully contained within the other, false otherwise
     */
    public static boolean rangesFullyContained(long startRange1, long endRange1, long startRange2, long endRange2) {
        return (((startRange1 <= startRange2) && (endRange1 >= endRange2)) ||
                ((startRange2 <= startRange1) && (endRange2 >= endRange1)));
    }

    /**
     * This function checks two ranges to see if Range 2 is fully contained within Range 1
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return true if range 2 is fully contained within range 1, otherwise false
     */
    public static boolean range2InsideRange1(long startRange1, long endRange1, long startRange2, long endRange2) {
        return ((startRange2 >= startRange1) && (endRange2 <= endRange1));
    }

    /**
     * This function determines the point at which two ranges start or stop overlapping
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return the value at which the ranges start or stop overlapping
     */
    public static long findOverlapPoint(long startRange1, long endRange1, long startRange2, long endRange2) {
        if (startRange1 == startRange2) {
            return Math.min(endRange1, endRange2);
        }
        else if (endRange1 == endRange2) {
            return Math.max(startRange1, startRange2);
        }
        else if ((startRange1 >= startRange2) && (startRange1 <= endRange2)) {
            return startRange1;
        }
        else if ((endRange1 >= startRange2) && (endRange1 <= endRange2)) {
            return startRange2;
        }
        else {
            throw new IllegalStateException("Tried to find the overlap point of ranges that were not overlapping!");
        }
    }

    /**
     * This function determines whether ranges that are overlapping are overlapped at the top or at the bottom
     * @param startRange1 The start index of the first range
     * @param endRange1 The end index of the first range
     * @param startRange2 The start index of the second range
     * @param endRange2 The end index of the second range
     * @return TOP if the ranges are overlapped such that the top of range 1 is overlapped with the bottom of range 2, otherwise BOTTOM
     */
    public static RangeOverlapType overlapDirection(long startRange1, long endRange1, long startRange2, long endRange2) {
        if ((startRange1 >= startRange2) && (startRange1 <= endRange2)) {
            return RangeOverlapType.BOTTOM;
        }
        else if ((endRange1 >= startRange2) && (endRange1 <= endRange2)) {
            return RangeOverlapType.TOP;
        }
        else {
            throw new IllegalStateException("Tried to find the overlap point of ranges that were not overlapping!");
        }
    }
}
