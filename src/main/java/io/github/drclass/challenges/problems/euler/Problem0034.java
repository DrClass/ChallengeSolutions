package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * <b>145</b> is a curious number, as <b>1! + 4! + 5! = 1 + 24 + 120 = 145</b>.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: As <b>1! = 1</b> and <b>2! = 2</b> are not sums they are not included.
 */
public class Problem0034 implements Problem {
    @Override
    public Result<?> solve() {
        int[] factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int upperBound = 2540160;
        int sum = 0;

        for (int i = 10; i <= upperBound; i++) {
            if (i == sumOfDigitFactorials(i, factorial)) {
                sum += i;
            }
        }

        return new Result<>(sum);
    }

    private int sumOfDigitFactorials(int n, int[] factorial) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += factorial[digit];
            n /= 10;
        }
        return sum;
    }
}
