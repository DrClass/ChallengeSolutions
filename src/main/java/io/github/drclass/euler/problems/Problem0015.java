package io.github.drclass.euler.problems;

import java.math.BigInteger;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * Starting in the top left corner of a 2 x 2 grid, and only being able to move to the
 * right and down, there are exactly 6 routes to the bottom right corner.<br>
 * How many such routes are there through a 20 x 20 grid?
 */

public class Problem0015 implements Problem {
	public Result<?> solve() {
		int n = 20;
		BigInteger result = factorial(n * 2).divide(factorial(n).multiply(factorial(n)));
		return new Result<>(result);
	}
	
	private BigInteger factorial(int num) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = num; i > 0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}
}
