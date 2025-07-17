package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.Arrays;

/**
 * Probability is the mathematical study of randomly occurring phenomena. We will model such a phenomenon with a random
 * variable, which is simply a variable that can take a number of different distinct outcomes depending on the result of
 * an underlying random process.
 * <p>
 * For example, say that we have a bag containing 3 red balls and 2 blue balls. If we let <b><i>X</i></b> represent the
 * random variable corresponding to the color of a drawn ball, then the probability of each of the two outcomes is given
 * by <b>Pr(<i>X</i> = red) = 3/5</b> and <b>Pr(<i>X</i> = blue) = 2/5</b>.
 * <p>
 * Random variables can be combined to yield new random variables. Returning to the ball example, let <b><i>Y</i></b>
 * model the color of a second ball drawn from the bag (without replacing the first ball). The probability of
 * <b><i>Y</i></b> being red depends on whether the first ball was red or blue. To represent all outcomes of
 * <b><i>X</i></b> and <b><i>Y</i></b>, we therefore use a probability tree diagram. This branching diagram represents
 * all possible individual probabilities for <b><i>X</i></b> and <b><i>Y</i></b>, with outcomes at the endpoints
 * ("leaves") of the tree. The probability of any outcome is given by the product of probabilities along the path from
 * the beginning of the tree.
 * <p>
 * An event is simply a collection of outcomes. Because outcomes are distinct, the probability of an event can be
 * written as the sum of the probabilities of its constituent outcomes. For our colored ball example, let
 * <b><i>A</i></b> be the event "<b><i>Y</i></b> is blue." <b>Pr(<i>A</i>)</b> is equal to the sum of the probabilities
 * of two different outcomes: <b>Pr(<i>X</i> = blue and <i>Y</i> = blue) + Pr(<i>X</i> = red and <i>Y</i> = blue)</b>,
 * or 3/10 + 1/10 = 2/5.
 * <p>
 * <b>Given</b>: Three positive integers <b><i>k</i></b>, <b><i>m</i></b>, and <b><i>n</i></b>, representing a
 * population containing <b><i>k + m + n</i></b> organisms: <b><i>k</i></b> individuals are homozygous dominant for a
 * factor, <b><i>m</i></b> are heterozygous, and <b><i>n</i></b> are homozygous recessive.<br>
 * <b>Return</b>: The probability that two randomly selected mating organisms will produce an individual possessing a
 * dominant allele (and thus displaying the dominant phenotype). Assume that any two organisms can mate.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code 2 2 2}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 0.78333}
 * <p>
 * <b>Hint</b><br>
 * Consider simulating inheritance on a number of small test cases in order to check your solution.
 */
public class ProblemIPRB implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/iprb.txt");
        Integer [] inputNums = Arrays.stream(input.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int k = inputNums[0];
        int m = inputNums[1];
        int n = inputNums[2];

        double t = k + m + n;

        double prob_aa_aa = (n / t) * ((n - 1) / (t - 1));
        double prob_Aa_aa = (m / t) * (n / (t - 1)) + (n / t) * (m / (t - 1));
        double prob_Aa_Aa = (m / t) * ((m - 1) / (t - 1));

        double prob_recessive = prob_aa_aa * 1 + prob_Aa_aa * 0.5 + prob_Aa_Aa * 0.25;

        return new Result<>(1 - prob_recessive);
    }

    @Override
    public String getName() {
        return "Mendel's First Law";
    }
}
