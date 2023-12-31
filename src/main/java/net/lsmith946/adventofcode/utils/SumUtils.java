package net.lsmith946.adventofcode.utils;

import java.util.HashSet;
import java.util.Set;

public class SumUtils {

    /**
     * This method takes a set of integers and determines which ones sum to a given targetValue
     *
     * @param targetValue      The value to which the operands must sum
     * @param numberOfOperands The number of operands in the sum
     * @param inputValues      The set of integers from which the operands can be selected
     * @return The set of integers from the inputValues which sum to the targetValue
     */
    public static Set<Integer> findUniqueIntsToSumTo(int targetValue, int numberOfOperands, Set<Integer> inputValues) {
        Set<Integer> result = new HashSet<>();
        if (numberOfOperands == 1) {
            if (inputValues.contains(targetValue)) {
                result.add(targetValue);
            }
        } else {
            for (Integer i : inputValues) {
                int remaining = targetValue - i;
                Set<Integer> intermediateResult = findUniqueIntsToSumTo(remaining, numberOfOperands - 1, inputValues);
                if (intermediateResult.size() != 0) {
                    result.addAll(intermediateResult);
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * This method takes a set of longs and determines which ones sum to a given targetValue
     *
     * @param targetValue      The value to which the operands must sum
     * @param numberOfOperands The number of operands in the sum
     * @param inputValues      The set of integers from which the operands can be selected
     * @return The set of integers from the inputValues which sum to the targetValue
     */
    public static Set<Long> findUniqueLongsToSumTo(long targetValue, int numberOfOperands, Set<Long> inputValues) {
        Set<Long> result = new HashSet<>();
        if (numberOfOperands == 1) {
            if (inputValues.contains(targetValue)) {
                result.add(targetValue);
            }
        } else {
            for (Long i : inputValues) {
                long remaining = targetValue - i;
                Set<Long> intermediateResult = findUniqueLongsToSumTo(remaining, numberOfOperands - 1, inputValues);
                if (intermediateResult.size() != 0) {
                    result.addAll(intermediateResult);
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}
