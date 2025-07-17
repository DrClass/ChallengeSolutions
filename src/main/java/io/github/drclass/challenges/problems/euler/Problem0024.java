package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012 021 102 120 201 210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 */
public class Problem0024 implements Problem {
	public Result<?> solve() {
		char[] digits = "0123456789".toCharArray();
		for (int i = 1; i < 1000000; i++) {
			permutate(digits);
		}
		//System.out.println(new String(digits));
		return new Result<>(digits);
	}

	public static boolean permutate(char[] sequence) {
		if (sequence.length < 2) {
			return false;
		}
		int i = sequence.length - 1;
		while (i > 0 && sequence[i - 1] >= sequence[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}
		int j = sequence.length - 1;
		while (j >= i && sequence[j] <= sequence[i - 1]) {
			j--;
		}
		// Swap elements at i-1 and j
		char temp = sequence[i - 1];
		sequence[i - 1] = sequence[j];
		sequence[j] = temp;
		// Reverse the subarray from i to the end of the array
		int start = i;
		int end = sequence.length - 1;
		while (start < end) {
			temp = sequence[start];
			sequence[start] = sequence[end];
			sequence[end] = temp;
			start++;
			end--;
		}
		return true;
	}
}
