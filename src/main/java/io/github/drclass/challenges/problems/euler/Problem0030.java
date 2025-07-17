package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 * <p>
 * <b>1634</b> = <b>1<sup>4</sup></b> + <b>6<sup>4</sup></b> +
 * <b>1<sup>4</sup></b> + <b>4<sup>4</sup></b><br>
 * <b>8208</b> = <b>8<sup>4</sup></b> + <b>2<sup>4</sup></b> +
 * <b>0<sup>4</sup></b> + <b>8<sup>4</sup></b><br>
 * <b>9474</b> = <b>9<sup>4</sup></b> + <b>4<sup>4</sup></b> +
 * <b>7<sup>4</sup></b> + <b>4<sup>4</sup></b>
 * <p>
 * As <b>1</b> = <b>1<sup>4</sup></b> is not a sum it is not included.
 * <p>
 * The sum of these numbers is <b>1634</b> + <b>8208</b> + <b>9474</b> =
 * <b>19316</b>.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 */

public class Problem0030 implements Problem {
	public Result<?> solve() {
		int tens[] = {
				100000,
				10000,
				1000,
				100,
				10,
				1 };
		int[] powResult = new int[10];
		for (int i = 0; i < powResult.length; i++) {
			powResult[i] = (int) Math.pow(i, 5);
		}
		// We get this number by guess and checking the best possible case for every
		// amount of digits in a number. A number with 7 9s (9999999), is to large to
		// work as 7 * 9 ^ 5 = 413343 and 413343 < 9999999. So the max number of digits
		// must be 6. We know this is true and the max possible value as 6 * 9 ^ 5 =
		// 354294 which is greater than 999999. As 354294 is the largest number we can
		// make, that is our max.
		int maxCount = 354294;
		int totalSum = 0;
		for (int i = 10; i < maxCount; i++) {
			int sum = 0;
			int num = i;
			// We are using this weird tens thing to get the digits at different positions
			// instead of using % as % is slow for the CPU compared to just looping and
			// adding a few extra times.
			for (int pos = 0; pos < 6; pos++) {
				int count = 0;
				while (num >= tens[pos]) {
					count++;
					num -= tens[pos];
				}
				sum += powResult[count];
			}
			if (sum == i) {
				totalSum += sum;
			}
		}
		return new Result<>(totalSum);
	}
}
