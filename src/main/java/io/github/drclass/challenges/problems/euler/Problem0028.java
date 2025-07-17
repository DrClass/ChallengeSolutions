package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * Starting with the number <b>1</b> and moving to the right in a clockwise
 * direction a <b>5</b> by <b>5</b> spiral is formed as follows:
 * <p>
 * 21 22 23 24 25<br>
 * 20 07 08 09 10<br>
 * 19 06 01 02 11<br>
 * 18 05 04 03 12<br>
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is <br>
 * 101</b>.
 * <p>
 * What is the sum of the numbers on the diagonals in a <br>
 * 1001</b> by <br>
 * 1001</b> spiral formed in the same way?
 */
public class Problem0028 implements Problem {
	public Result<?> solve() {
		int matrixSize = 1001;
		int sum = 1;
		int value = 1;
		for (int i = 1; i <= Math.ceil(matrixSize / 2); i++) {
			sum += 4 * value + i * 20;
			value = value + i * 8;
		}
		return new Result<>(sum);
	}
}
