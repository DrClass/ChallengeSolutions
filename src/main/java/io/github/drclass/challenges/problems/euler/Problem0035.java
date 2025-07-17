package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.CollectionConverters;
import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.HashSet;
import java.util.Set;

/**
 * The number, <b>197</b>, is called a circular prime because all rotations of the digits: <b>197, 971,</b> and
 * <b>719</b> are themselves prime.
 * <p>
 * There are thirteen such primes below <b>100</b>: <b>2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79,</b> and <b>97</b>.
 * <p>
 * How many circular primes are there below one million?
 */
public class Problem0035 implements Problem {
    @Override
    public Result<?> solve() {
        Set<Integer> primes = new HashSet<>(CollectionConverters.toList(Primes.sievePrimes(1_000_000)));

        int count = 0;
        for (int prime : primes) {
            if (isCircularPrime(prime, primes)) {
                count++;
            }
        }
        return new Result<>(count);
    }

    private static boolean isCircularPrime(int n, Set<Integer> primeSet) {
        String s = String.valueOf(n);
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            int rotatedNum = Integer.parseInt(rotated);
            if (!primeSet.contains(rotatedNum)) {
                return false;
            }
        }
        return true;
    }
}
