package net.lsmith946.adventofcode.utils;

public class RangeUtils {

    public enum RangeOverlapType { START_INSIDE, FINISH_INSIDE };

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
     * This function determines whether ranges that are overlapping are overlapped at the top or at the bottom
     * @param refRangeStart The start index of the reference range
     * @param refRangeEnd The end index of the reference range
     * @param targetRangeStart The start index of the target range
     * @param targetRangeEnd The end index of the target range
     * @return the start or end point of the overlapping portion of the range
     */
    public static long findOverlapPoint(long refRangeStart, long refRangeEnd, long targetRangeStart, long targetRangeEnd) {
        RangeOverlapType overlapType = overlapType(refRangeStart, refRangeEnd, targetRangeStart, targetRangeEnd);
        if (overlapType == RangeOverlapType.START_INSIDE) {
            return targetRangeStart;
        }
        else {
            return targetRangeEnd;
        }
    }

    /**
     * This function determines whether ranges that are overlapping are overlapped at the top or at the bottom
     * @param refRangeStart The start index of the reference range
     * @param refRangeEnd The end index of the reference range
     * @param targetRangeStart The start index of the target range
     * @param targetRangeEnd The end index of the target range
     * @return START_INSIDE if the target range starts inside the reference range, FINISH_INSIDE if the target range finishes inside the reference range
     * START_INSIDE takes priority so if the target range is fully contained within the reference it will return START_INSIDE
     */
    public static RangeOverlapType overlapType(long refRangeStart, long refRangeEnd, long targetRangeStart, long targetRangeEnd) {
        if ((targetRangeStart >= refRangeStart) && (targetRangeStart <= refRangeEnd)) {
            return RangeOverlapType.START_INSIDE;
        }
        else if ((targetRangeEnd >= refRangeStart) && (targetRangeEnd <= refRangeEnd)) {
            return RangeOverlapType.FINISH_INSIDE;
        }
        else {
            throw new IllegalStateException("Tried to find the overlap point of ranges that were not overlapping!");
        }
    }
}
