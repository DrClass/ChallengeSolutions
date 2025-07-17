package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The number <b>3797</b> has an interesting property. Being prime itself, it is possible to continuously remove digits
 * from left to right, and remain prime at each stage: <b>3797</b>, <b>797</b>, <b>97</b>, and <b>7</b>. Similarly, we
 * can work from right to left: <b>3797</b>, <b>379</b>, <b>37</b>, and <b>3</b>.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: <b>2</b>, <b>3</b>, <b>5</b>, and <b>7</b> are not considered to be truncatable primes.
 */
public class Problem0037 implements Problem {
    private List<Integer> primes;

    @Override
    public Result<?> solve() {
        // We know 3797 is one of the primes, so lets get all primes up to that since we will need them anyway
        primes = Arrays.stream(Primes.sievePrimes(3797)).boxed().collect(Collectors.toList());
        List<Integer> truncatablePrimes = new ArrayList<Integer>();
        for (Integer prime : primes) {
            if (prime < 10) {
                continue;
            }
            if (isTruncatable(prime)) {
                truncatablePrimes.add(prime);
            }
        }
        // Continue until we find all 11
        while (truncatablePrimes.size() < 11) {
            int n = Primes.nextPrime(primes.get(primes.size() - 1) + 1);
            primes.add(n);
            if (isTruncatable(n)) {
                truncatablePrimes.add(n);
            }
        }
        int sum = truncatablePrimes.stream().mapToInt(Integer::intValue).sum();
        return new Result<>(sum);
    }

    private boolean isTruncatable(int n) {
        // --- Right-to-left truncation (remove trailing digits) ------------------
        for (int value = n / 10; value > 0; value /= 10) {   // 3797 → 379 → 37 → 3
            if (!primes.contains(value)) {
                return false;
            }
        }
        // --- Left-to-right truncation (remove leading digits) -------------------
        // 3797 → 797 → 97 → 7
        for (int divisor = 10; divisor <= n; divisor *= 10) {
            int value = n % divisor;                         // keep the right-most k digits
            if (value != 0 && !primes.contains(value)) {
                return false;
            }
        }
        return true; // all truncated forms were prime
    }
}
