package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.<br>
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
public class Problem0005 implements Problem {
	public Result<?> solve() {
		long lcm = 1;
		for (int i = 2; i <= 20; i++) {
			lcm = getLCM(lcm, i);
		}
		return new Result<>(lcm);
	}

	public static long getLCM(long a, long b) {
		return (a * b) / getGCD(a, b);
	}

	public static long getGCD(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
