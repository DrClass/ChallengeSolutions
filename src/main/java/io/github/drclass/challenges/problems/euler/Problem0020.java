package io.github.drclass.challenges.problems.euler;

import io.github.drclass.commons.math.Factorial;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * n! means n * (n - 1) * ... * 3 * 2 * 1.<br>
 * For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 .<br>
 * Find the sum of the digits in the number 100! .
 */
public class Problem0020 implements Problem {
	public Result<?> solve() {
		return new Result<>(Factorial.bigIntValue(100).toString().chars().map(x -> x - '0').sum());
	}
}
