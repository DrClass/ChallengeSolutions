package io.github.drclass.euler.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:<br>
 * 1/2 = 0.5<br>
 * 1/3 = 0.(3)<br>
 * 1/4 = 0.25<br>
 * 1/5 = 0.2<br>
 * 1/6 = 0.1(6)<br>
 * 1/7 = 0.(142857)<br>
 * 1/8 = 0.125<br>
 * 1/9 = 0.(1)<br>
 * 1/10 = 0.1
 * <p>
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 * <p>
 * Find the value of d &lt; 1000 for which 1/d contains the longest recurring
 * cycle in its decimal fraction part.
 */
public class Problem0026 implements Problem {
	public Result<?> solve() {
		ArrayList<Integer> maxCycle = new ArrayList<>(List.of(0, 0));
		for (int i = 2; i < 1000; ++i) {
			int cycleLength = cycleLength(i, 1, new ArrayList<Integer>());
			maxCycle = (cycleLength > maxCycle.get(0)) ? new ArrayList<Integer>(List.of(cycleLength, i)) : maxCycle;
		}
		return new Result<>(maxCycle.get(1));
	}

	public static int cycleLength(int n, int r, ArrayList<Integer> remainders) {
		if (r < n) {
			return cycleLength(n, r * 10, remainders);
		}
		if (r % n == 0) {
			return 0;
		}
		if (remainders.contains(r % n)) {
			return remainders.size() - remainders.indexOf(r % n);
		}
		remainders.add(r % n);
		return cycleLength(n, r % n, remainders);
	}
}
