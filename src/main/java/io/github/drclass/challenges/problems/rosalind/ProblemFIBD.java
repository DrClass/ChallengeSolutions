package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.Arrays;

/**
 * Recall the definition of the Fibonacci numbers from “Rabbits and Recurrence Relations”, which followed the recurrence
 * relation <b><i>F<sub>n</sub></i> = <i>F<sub>n</sub></i> - 1 + <i>F<sub>n</sub> - 2</i></b> and assumed that each pair
 * of rabbits reaches maturity in one month and produces a single pair of offspring (one male, one female) each
 * subsequent month.
 * <p>
 * Our aim is to somehow modify this recurrence relation to achieve a dynamic programming solution in the case that all
 * rabbits die out after a fixed number of months.
 * <p>
 * <b>Given</b>: Positive integers <b><i>n</i> &le; 100</b> and <b><i>m</i> &le; 20</b>.<br>
 * <b>Return</b>: The total number of pairs of rabbits that will remain after the <b><i>n</i></b>-th month if all
 * rabbits live for <b><i>m</i></b> months.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code 6 3}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 4}
 */
public class ProblemFIBD implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/fibd.txt");
        Integer [] inputNums = Arrays.stream(input.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int n = inputNums[0];
        int m = inputNums[1];

        long[] ages = new long[m];

        ages[0] = 1;

        for (int month = 2; month <= n; month++) {
            long newBorns = 0;
            for (int i = 1; i < m; i++) {
                newBorns += ages[i];
            }

            for (int i = m - 1; i > 0; i--) {
                ages[i] = ages[i - 1];
            }
            ages[0] = newBorns;
        }

        long total = 0;
        for (long count : ages) {
            total += count;
        }

        return new Result<>(total);
    }

    @Override
    public String getName() {
        return "Mortal Fibonacci Rabbits";
    }
}
