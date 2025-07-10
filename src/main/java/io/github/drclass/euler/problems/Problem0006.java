package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * The sum of the squares of the first ten natural numbers is, 1<sup>2</sup> +
 * 2<sup>2</sup> + ... + 10<sup>2</sup> = 385.<br>
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
 * 10)<sup>2</sup> = 55<sup>2</sup> = 3025.<br>
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 &#45 385 = 2640.<br>
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
public class Problem0006 implements Problem {
	public Result<?> solve() {
		long sum = 0;
		long sumOfSquares = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			sumOfSquares += Math.pow(i, 2);
		}
		long difference = (long) (Math.pow(sum, 2) - sumOfSquares);
		return new Result<>(difference);
	}
}
