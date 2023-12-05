package net.lsmith946.adventofcode.utils;

public class RangeUtils {

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
}
