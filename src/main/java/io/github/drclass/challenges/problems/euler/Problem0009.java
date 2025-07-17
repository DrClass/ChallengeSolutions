package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for
 * which, a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>.<br>
 * For example, 3<sup>2</sup> + 4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>.<br>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.<br>
 * Find the product abc.
 */
public class Problem0009 implements Problem {
	public Result<?> solve() {
		int product = 0;
		outer:
		for (int a = 1; a < 333; a++) {
			for (int c = 977 - a; c > 335; c--) {
				int b = 1000 - c - a;
				if (c <= b) {
					break;
				}
				if ((a * a) + (b * b) == c * c) {
					product = a * b * c;
					break outer;
				}
			}
		}
		return new Result<>(product);
	}
}
