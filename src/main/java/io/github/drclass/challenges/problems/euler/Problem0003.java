package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * The prime factors of 13195 are 5, 7, 13, and 29.<br>
 * What is the largest prime factor of the number 600851475143?
 */
public class Problem0003 implements Problem {
	public Result<?> solve() {
		long num = 600851475143L;
		int max = (int) Math.sqrt(num);
		int[] primes = Primes.sievePrimes(max);
		for (int i = primes.length - 1; i >= 0; i--) {
			if (num % primes[i] == 0) {
				return new Result<>(primes[i]);
			}
		}
		return null;
	}
}
