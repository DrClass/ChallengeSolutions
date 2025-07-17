package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.Arrays;

/**
 * A sequence is an ordered collection of objects (usually numbers), which are allowed to repeat. Sequences can be
 * finite or infinite. Two examples are the finite sequence <b>(&pi;, -&radic;2, 0, &pi;)</b> and the infinite sequence
 * of odd numbers <b>(1, 3, 5, 7, 9, ...)</b>. We use the notation <b><i>a<sub>n</sub></i></b> to represent the
 * <b><i>n</i></b>-th term of a sequence.
 * <p>
 * A recurrence relation is a way of defining the terms of a sequence with respect to the values of previous terms. In
 * the case of Fibonacci's rabbits from the introduction, any given month will contain the rabbits that were alive the
 * previous month, plus any new offspring. A key observation is that the number of offspring in any month is equal to
 * the number of rabbits that were alive two months prior. As a result, if <b><i>F<sub>n</sub></i></b> represents the
 * number of rabbit pairs alive after the <b><i>n</i></b>-th month, then we obtain the Fibonacci sequence having terms
 * <b><i>F<sub>n</sub></i></b> that are defined by the recurrence relation <b><i>F<sub>n</sub></i> = <i>F<sub>n</sub>
 * </i> - 1 + <i>F<sub>n</sub> - 2</i></b> (with <b><i>F<sub>1</sub></i> = <i>F<sub>2</sub></i> = 1</b> to initiate the
 * sequence). Although the sequence bears Fibonacci's name, it was known to Indian mathematicians over two millennia
 * ago.
 * <p>
 * When finding the <b><i>n</i></b>-th term of a sequence defined by a recurrence relation, we can simply use the
 * recurrence relation to generate terms for progressively larger values of <b><i>n</i></b>. This problem introduces us
 * to the computational technique of dynamic programming, which successively builds up solutions by using the answers to
 * smaller cases.
 * <p>
 * <b>Given</b>: Positive integers <b><i>n</i> &le; 40</b> and <b><i>k</i> &le; 5</b>.<br>
 * <b>Return</b>: The total number of rabbit pairs that will be present after <b><i>n</i></b> months, if we begin with 1
 * pair and in each generation, every pair of reproduction-age rabbits produces a litter of <b><i>k</i></b> rabbit pairs
 * (instead of only 1 pair).
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code 5 3}
 * <b>Sample Output</b><br>
 * {@code 19}
 */
public class ProblemFIB implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/fib.txt");
        Integer [] inputNums = Arrays.stream(input.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int n = inputNums[0];
        int k = inputNums[1];

        long[] pairs = new long[n + 1];
        pairs[1] = 1;
        pairs[2] = 1;

        for (int i = 3; i <= n; i++) {
            pairs[i] = pairs[i - 1] + k * pairs[i - 2];
        }

        return new Result<>(pairs[n]);
    }

    @Override
    public String getName() {
        return "Rabbits and Recurrence Relations";
    }
}
