package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.CollectionConverters;
import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.Set;

/**
 * We shall say that an <b><i>n</i></b>-digit number is pandigital if it makes use of all the digits <b>1</b> to
 * <b><i>n</i></b> exactly once. For example, <b>2143</b> is a <b>4</b>-digit pandigital and is also prime.
 * <p>
 * What is the largest <b><i>n</i></b>-digit pandigital prime that exists?
 */
public class Problem0041 implements Problem {
    @Override
    public Result<?> solve() {
        int[] primes = Primes.sievePrimes(7_654_321);
        int prime = 0;
        Set<Integer> digits = Set.of(1, 2, 3, 4, 5, 6, 7);
        for (int i = primes.length - 1; i >= 0; i--) {
            Set<Integer> primeDigits = CollectionConverters.toSet(Integer.toString(primes[i]).chars().map(c -> c - '0').toArray());
            if (primeDigits.containsAll(digits) && primeDigits.size() == digits.size()) {
                prime = primes[i];
                break;
            }
        }
        return new Result<>(prime);
    }
}
