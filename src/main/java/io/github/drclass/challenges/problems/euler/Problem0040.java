package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:<br>
 * <b>0.12345678910<u>1</u>112131415161718192021...</b>
 * <p>
 * It can be seen that the <b>12</b><sup>th</sup> digit of the fractional part is <b>1</b>.
 * <p>
 * If <b>d<sub>n</sub></b> represents the <b>n</b><sup>th</sup> digit of the fractional part, find the value of the
 * following expression.<br>
 * <b>d<sub>1</sub> * d<sub>10</sub> * d<sub>100</sub> * d<sub>1000</sub> * d<sub>10000</sub> * d<sub>100000</sub> *
 * d<sub>1000000</sub></b>
 */
public class Problem0040 implements Problem {
    @Override
    public Result<?> solve() {
        StringBuilder num = new StringBuilder();
        int current = 1;
        int limit = 1_000_000;
        int searchIndex = 1;
        int product = 1;
        do {
            num.append(current++);
            if (num.length() >= searchIndex) {
                product *= Character.getNumericValue(num.charAt(searchIndex - 1));
                searchIndex *= 10;
            }
        } while(num.length() < limit);

        return new Result<>(product);
    }
}
