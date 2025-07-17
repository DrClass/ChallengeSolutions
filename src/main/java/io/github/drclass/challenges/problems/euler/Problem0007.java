package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.math.Primes;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.<br>
 * What is the 10001st prime number?
 */
public class Problem0007 implements Problem {
	public Result<?> solve() {
		return new Result<>(Primes.findPrimes(10001)[10000]);
	}
}
