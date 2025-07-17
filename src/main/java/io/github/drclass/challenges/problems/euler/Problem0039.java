package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * If <b><i>p</i></b> is the perimeter of a right angle triangle with integral length sides, <b>{<i>a, b, c</i>}</b>,
 * there are exactly three solutions for <b><i>p</i> = 120</b>.
 * <p>
 * <b>{20, 48, 52}, {24, 45, 51}, {30, 40, 50}</b>
 * <p>
 * For which value of <b><i>p</i> &le; 1000</b>, is the number of solutions maximised?
 */
public class Problem0039 implements Problem {
    @Override
    public Result<?> solve() {
        int maxSolutions = 0;
        int bestP = 0;

        for (int p = 12; p <= 1000; p++) {
            int solutions = 0;
            for (int a = 1; a < p / 3; a++) {
                for (int b = a + 1; b < p / 2; b++) {
                    int c = p - a - b;
                    if (a * a + b * b == c * c) {
                        solutions++;
                    }
                }
            }
            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                bestP = p;
            }
        }
        return new Result<>(bestP);
    }
}
