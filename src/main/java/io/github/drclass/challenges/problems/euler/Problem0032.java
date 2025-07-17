package io.github.drclass.challenges.problems.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * We shall say that an <i><b>n</b></i>&#45;digit number is pandigital if it
 * makes use of all the digits <b>1</b> to <i><b>n</b></i> exactly once; for
 * example, the <b>5</b>&#45;digit number, <b>15234</b>, is <b>1</b> through
 * <b>5</b> pandigital.
 * <p>
 * The product <b>7254</b> is unusual, as the identity, <b>39 x 186 = 7254</b>,
 * containing multiplicand, multiplier, and product is <b>1</b> through <b>9</b>
 * pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a <b>1</b> through <b>9</b> pandigital.
 * <p>
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 */
public class Problem0032 implements Problem {
	public Result<?> solve() {
		// must be a 2 two digit times 3 digit product to have nine digits
		Set<Integer> products = new HashSet<Integer>();
		for (int a = 1; a <= 99; ++a) {
			for (int b = 100; b <= 9999; ++b) {
				if (isPandigitalProduct(a, b, a * b)) {
					products.add(a * b);
				}
			}
		}
		int sum = 0;
        for (Integer num : products) {
            sum += num;
        }
		return new Result<>(sum);
	}

	private static boolean isPandigitalProduct(int a, int b, int c) {
		ArrayList<Integer> digits = new ArrayList<>();
		return check(a, digits) && check(b, digits) && check(c, digits) && digits.size() == 9;
	}

	private static boolean check(int n, ArrayList<Integer> digits) {
		while (n != 0) {
			int lastDigit = n % 10;
			if (digits.contains(lastDigit) || lastDigit == 0) {
				return false;
			}
			digits.add(lastDigit);
			n /= 10;
		}
		return true;
	}
}
