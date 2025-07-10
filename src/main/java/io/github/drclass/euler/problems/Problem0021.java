package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).<br>
 * If d(a) = b and d(b) = a, where a \= b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem0021 implements Problem {
	public Result<?> solve() {
		int limit = 10000;
		int totalSum = 0;
		int[] sumDivisors = new int[limit];

		for (int i = 1; i < limit; i++) {
			sumDivisors[i] = sumOfDivisors(i);
		}

		for (int i = 2; i < limit; i++) {
			int sum = sumDivisors[i];
			if (sum != i && sum < limit && sumDivisors[sum] == i) {
				totalSum += i + sum;
				sumDivisors[i] = sumDivisors[sum] = 0;
			}
		}
		return new Result<>(totalSum);
	}

	private int sumOfDivisors(int n) {
		int sum = 1;
		int step = (n % 2 == 0) ? 1 : 2;
		int sqrt_n = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt_n; i += step) {
			if (n % i == 0) {
				sum += i;
				if (i != n / i) {
					sum += n / i;
				}
			}
		}
		return sum;
	}
}
