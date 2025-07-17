package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192<br> 192 × 2 = 384<br> 192 × 3 = 576<br>
 * <p>
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3).
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer
 * with (1,2, ... , n) where n &gt; 1?
 */
public class Problem0038 implements Problem {
    @Override
    public Result<?> solve() {
        int limit = 10000;
        int largestPandigitalMultiple = 123456789;
        for (int i = 2; i < limit; i++) {
            int mult = i;
            for (int m = 2; m < 9; m++) {
                mult = appendInt(mult, i * m);
                if (hasDuplicateDigits(mult)) {
                    break;
                }
                if (mult > largestPandigitalMultiple) {
                    largestPandigitalMultiple = mult;
                    break;
                }
            }
        }
        return new Result<>(largestPandigitalMultiple);
    }

    /*
     * Appends the value of b to the end of a. For example: if a = 12 and b = 34, this would return 1234.
     */
    private int appendInt(int a, int b) {
        // Determine the factor to shift 'a' left by as many decimal places as 'b' has.
        int m = 10;
        while (b >= m) {
            m *= 10;
        }
        return a * m + b;
    }

    /*
     * Checks if there is a duplicate digit in the number. 0 is not counted as a digit for this method.
     */
    private boolean hasDuplicateDigits(int n) {
        // If the number is large enough, we know for a fact there HAS to be a duplicate
        if (n >= 1_000_000_000) {
            return true;
        }

        // seen[d] == true once we've encountered digit d (1–9)
        boolean[] seen = new boolean[10];

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                if (seen[digit]) {
                    // we saw this non-zero digit before -> duplicate
                    return true;
                }
                seen[digit] = true;
            } else {
                return true;
            }
            n /= 10;
        }

        // no non-zero digit repeated
        return false;
    }
}
