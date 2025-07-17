package io.github.drclass.challenges.problems.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.github.drclass.commons.math.Divisors;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */
public class Problem0023 implements Problem {
	public Result<?> solve() {
		List<Integer> abundants = new ArrayList<>();
		Set<Integer> sums = new HashSet<>();
		int total = 0;
		for (int i = 1; i <= 28123; i++) {
			int sum = Divisors.getDivisors(i).stream().mapToInt(Integer::intValue).sum() - i;
			if (sum > i) {
				abundants.add(i);
			}
		}
		for (int i = 0; i < abundants.size(); i++) {
			for (int j = 0; j < abundants.size(); j++) {
				int sum = abundants.get(i) + abundants.get(j);
				if (sum <= 28123) {
					sums.add(sum);
				} else {
					break;
				}
			}
		}
		for (int i = 0; i <= 28123; i++) {
			if (!sums.contains(i)) {
				total += i;
			}
		}
		return new Result<>(total);
	}
}
