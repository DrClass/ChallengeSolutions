package io.github.drclass.challenges.problems.euler;

import java.math.BigInteger;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * 2<sup>15</sup> = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 =
 * 26.<br>
 * What is the sum of the digits of the number 2<sup>1000</sup>?
 */
public class Problem0016 implements Problem {
	public Result<?> solve() {
		return new Result<>(BigInteger.TWO.pow(1000).toString().chars().map(i -> Character.getNumericValue(i)).sum());
	}
}
