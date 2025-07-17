package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.Arrays;

/**
 * For a random variable <b><i>X</i></b> taking integer values between 1 and <i>n</i>, the expected value of
 * <b><i>X</i></b> is <b>E(<i>X</i>) = &Sigma;<sup><i>n</i></sup><sub><i>k</i>=1</sub> <i>k</i> * PR(<i>X</i> = k)</b>.
 * The expected value offers us a way of taking the long-term average of a random variable over a large number of
 * trials.
 * <p>
 * As a motivating example, let <b><i>X</i></b> be the number on a six-sided die. Over a large number of rolls, we
 * should expect to obtain an average of 3.5 on the die (even though it's not possible to roll a 3.5). The formula for
 * expected value confirms that <b>E(<i>X</i>) = &Sigma;<sup><i>6</i></sup><sub><i>k</i>=1</sub> <i>k</i> * PR(<i>X</i>
 * = k) = 3.5</b>.
 * <p>
 * More generally, a random variable for which every one of a number of equally spaced outcomes has the same probability
 * is called a uniform random variable (in the die example, this "equal spacing" is equal to 1). We can generalize our
 * die example to find that if <b><i>X</i></b> is a uniform random variable with minimum possible value <i>a</i> and
 * maximum possible value <i>b</i>, then <b>E(<i>X</i>)= (<i>a</i>+<i>b</i>)/2</b>. You may also wish to verify that for
 * the dice example, if <b><i>Y</i></b> is the random variable associated with the outcome of a second die roll, then
 * <b>E(<i>X</i>+<i>Y</i>) = 7</b>.
 * <p>
 * <b>Given</b>: Six nonnegative integers, each of which does not exceed 20,000. The integers correspond to the number
 * of couples in a population possessing each genotype pairing for a given factor. In order, the six given integers
 * represent the number of couples having the following genotypes:
 * <ol>
 *     <li>AA-AA</li>
 *     <li>AA-Aa</li>
 *     <li>AA-aa</li>
 *     <li>Aa-Aa</li>
 *     <li>Aa-aa</li>
 *     <li>aa-aa</li>
 * </ol>
 * <b>Return</b>: The expected number of offspring displaying the dominant phenotype in the next generation, under the
 * assumption that every couple has exactly two offspring.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code 1 0 0 1 0 1}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 3.5}
 */
public class ProblemIEV implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/iev.txt");
        Integer [] inputNums = Arrays.stream(input.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        double[] expectedPerCouple = {2.0, 2.0, 2.0, 1.5, 1.0, 0.0};

        double totalExpected = 0.0;

        for (int i = 0; i < 6; i++) {
            totalExpected += inputNums[i] * expectedPerCouple[i];
        }

        return new Result<>(totalExpected);
    }

    @Override
    public String getName() {
        return "Calculating Expected Offspring";
    }
}
