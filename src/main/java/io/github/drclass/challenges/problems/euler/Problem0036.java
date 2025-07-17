package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * The decimal number, <b>585 = 1001001001<sub>2</sub></b> (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base <b>10</b> and base <b>2</b>.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem0036 implements Problem {
    @Override
    public Result<?> solve() {
        int limit = 1_000_000;
        int sum = 0;

        for (int i = 1; i < limit; i++) {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }

        return new Result<>(sum);
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
