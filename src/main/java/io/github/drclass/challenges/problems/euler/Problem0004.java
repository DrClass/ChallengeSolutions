package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * Palindromic number reads the same both ways. The largest palindrome made from
 * the product of two 2-digit numbers is 9009 = 91 x 99.<br>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem0004 implements Problem {
	public Result<?> solve() {
		int largestPalindrome = 0;
		int product;
		for (int i = 999; i >= 100; i--) {
			for (int j = i; j >= 100; j--) {
				product = i * j;
				if (isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		return new Result<>(largestPalindrome);
	}

	public boolean isPalindrome(int number) {
		int reverse = 0;
		int original = number;
		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			number /= 10;
		}
		return original == reverse;
	}
}
