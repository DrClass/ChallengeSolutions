package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Two events <b><i>A</i></b> and <b><i>B</i></b> are independent if <b>Pr(<i>A</i> and <i>B</i>)</b> is equal to
 * <b>Pr(<i>A</i>) * Pr(<i>B</i>)</b>. In other words, the events do not influence each other, so that we may simply
 * calculate each of the individual probabilities separately and then multiply.
 * <p>
 * More generally, random variables <b><i>X</i></b> and <b><i>Y</i></b> are independent if whenever <b><i>A</i></b> and
 * <b><i>B</i></b> are respective events for <b><i>X</i></b> and <b><i>Y</i></b>, <b><i>A</i></b> and <b><i>B</i></b>
 * are independent (i.e., <b>Pr(<i>A</i> and <i>B</i>) = Pr(<i>A</i>) * Pr(<i>B</i>)</b>).
 * <p>
 * As an example of how helpful independence can be for calculating probabilities, let <b><i>X</i></b> and <b><i>Y</i>
 * </b> represent the numbers showing on two six-sided dice. Intuitively, the number of pips showing on one die should
 * not affect the number showing on the other die. If we want to find the probability that <b><i>X</i> + <i>Y</i></b> is
 * odd, then we don't need to draw a tree diagram and consider all possibilities. We simply first note that for <b><i>X
 * </i> + <i>Y</i></b> to be odd, either <b><i>X</i></b> is even and <b><i>Y</i></b> is odd or <b><i>X</i></b> is odd
 * and <b><i>Y</i></b> is even. In terms of probability, <b>Pr(<i>X</i> + <i>Y</i> is odd) = Pr(<i>X</i> is even and
 * <i>Y</i> is odd) + Pr(<i>X</i> is odd and <i>Y</i> is even). Using independence, this becomes <b>[Pr(<i>X</i> is
 * even) * Pr(<i>Y</i> is odd)] + [Pr(<i>X</i> is odd) * Pr(<i>Y</i> is even)]</b>, or (1/2)<sup>2</sup> + (1/2)<sup>2
 * </sup> = 12.
 * <p>
 * <b>Given</b>: Two positive integers <b><i>k</i></b> (<b><i>k</i> &le; 7</b>) and <b><i>N</i></b> (<b><i>N</i> &le;
 * 2<sup><i>k</i></sup></b>). In this problem, we begin with Tom, who in the 0th generation has genotype Aa Bb. Tom has
 * two children in the 1st generation, each of whom has two children, and so on. Each organism always mates with an
 * organism having genotype Aa Bb.<br>
 * <b>Return</b>: The probability that at least <b><i>N</i></b> Aa Bb organisms will belong to the <b><i>k</i></b>-th
 * generation of Tom's family tree (don't count the Aa Bb mates at each level). Assume that Mendel's second law holds
 * for the factors.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code 2 1}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 0.684}
 */
public class ProblemLIA implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/lia.txt");
        Integer [] inputNums = Arrays.stream(input.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);

        int k = inputNums[0];
        int n = inputNums[1];

        int total = 1 << k; // 2^k
        double p = 0.25;
        double q = 1 - p;
        double prob = 0.0;

        for (int i = n; i <= total; i++) {
            double binom = binomialCoeff(total, i);
            prob += binom * Math.pow(p, i) * Math.pow(q, total - i);
        }

        return new Result<>(prob);
    }

    private static double binomialCoeff(int n, int k) {
        double result = 1.0;
        for (int i = 1; i <= k; i++) {
            result *= (n - i + 1) / (double) i;
        }
        return result;
    }

    @Override
    public String getName() {
        return "Independent Alleles";
    }
}
