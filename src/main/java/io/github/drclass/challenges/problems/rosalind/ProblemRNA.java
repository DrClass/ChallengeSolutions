package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
 *  <p>
 * Given a DNA string <i>t</i> corresponding to a coding strand, its transcribed RNA string <i>u</i> is formed by
 * replacing all occurrences of 'T' in <i>t</i> with 'U' in <i>u</i>.
 * <p>
 * <b>Given</b>: A DNA string <i>t</i> having length at most 1000 nt.<br>
 * <b>Return</b>: The transcribed RNA string of <i>t</i>.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code GATGGAACTTGACTACGTAAATT}
 * <p>
 * <b>Sample Output</b><br>
 * {@code GAUGGAACUUGACUACGUAAAUU}
 */
public class ProblemRNA implements Problem {
    @Override
    public Result<?> solve() {
        String dna = ResourceUtils.loadResourceAsString("rosalind/rna.txt");
        String rna = dna.replaceAll("T", "U");
        return new Result<>(rna);
    }

    @Override
    public String getName() {
        return "Transcribing DNA into RNA";
    }
}
