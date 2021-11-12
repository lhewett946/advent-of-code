package net.lsmith946.adventofcode.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ChineseRemainderTheorem {

    /**
     * Based on: https://github.com/anujpahade/CRT/blob/master/CRT.java
     * @return solving the Chinese Remainder Theorem returns the lowest possible number which satisfies the map of divisors to modulos
     */
    public static long solve(Map<Long, Long> divisorsAndModulos) {
        Set<Long> divisorSet = divisorsAndModulos.keySet();
        List<Long> divisors = new ArrayList<>(divisorSet);
        long product = productOfDivisors(divisors);
        List<Long> partialProducts = partialProducts(divisors, product);
        List<Long> inverses = computeInverses(partialProducts, divisors);
        long sum = 0;
        for (int i = 0; i < divisors.size(); i++) {
            sum += (partialProducts.get(i) * inverses.get(i) * divisorsAndModulos.get(divisors.get(i)));
        }
        return sum % product;
    }

    private static long productOfDivisors(List<Long> divisors) {
        long product = 1;
        for (Long divisor : divisors) {
            product *= divisor;
        }
        return product;
    }

    private static List<Long> partialProducts(List<Long> divisors, long overallProduct) {
        List<Long> partialProducts = new ArrayList<>();
        for (Long divisor : divisors) {
            long partialProduct = overallProduct / divisor;
            partialProducts.add(partialProduct);
        }
        return partialProducts;
    }

    private static List<Long> computeInverses(List<Long> partialProducts, List<Long> divisors) {
        List<Long> inverses = new ArrayList<>();
        for (int i = 0; i < partialProducts.size(); i++) {
            long product = partialProducts.get(i);
            long divisor = (long) divisors.toArray()[i];
            long x = 0, y = 1;
            if (divisor == 1) {
                inverses.add(0L);
            } else {
                // Extended Euclid algorithm
                while (product > 1) {
                    long quotient = product / divisor;
                    long temp = divisor;
                    divisor = product % divisor;
                    product = temp;

                    temp = x;
                    x = y - quotient * x;
                    y = temp;
                }

                // if the inverse is negative, add the divisor to convert to positive
                if (y < 0) {
                    y += (long) divisors.toArray()[i];
                }
                inverses.add(y);
            }
        }
        return inverses;
    }
}
