package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.<br>
 * Find the sum of all the primes below two million.
 */
public class Problem0010 implements Problem {
	public Result<?> solve() {
		int[] primes = Primes.sievePrimes(2_000_000);
		long sum = 0;
		for (int prime : primes) {
			sum += prime;
		}
		return new Result<>(sum);
	}
}
