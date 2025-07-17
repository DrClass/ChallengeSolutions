package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;
import io.github.drclass.challenges.problems.rosalind.utils.Codon;

/**
 * In a weighted alphabet, every symbol is assigned a positive real number called a weight. A string formed from a
 * weighted alphabet is called a weighted string, and its weight is equal to the sum of the weights of its symbols.
 * <p>
 * The standard weight assigned to each member of the 20-symbol amino acid alphabet is the monoisotopic mass of the
 * corresponding amino acid.
 * <p>
 * <b>Given</b>: A protein string <b><i>P</i></b> of length at most 1000 aa.<br>
 * <b>Return</b>: The total weight of <b><i>P</i></b>. Consult the monoisotopic mass table.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code SKADYEK}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 821.392}
 */
public class ProblemPRTM implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/prtm.txt");
        double mass = 0;
        for (char c : input.toCharArray()) {
            mass += Codon.valueOf(String.valueOf(c)).getMass();
        }
        return new Result<>(mass);
    }

    @Override
    public String getName() {
        return "Calculating Protein Mass";
    }
}
