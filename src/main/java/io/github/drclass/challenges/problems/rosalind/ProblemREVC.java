package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
 * <p>
 * The reverse complement of a DNA string <i>s</i> is the string <i>s<sup>c</sup></i> formed by reversing the symbols of
 * <i>s</i>, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").
 * <p>
 * <b>Given</b>: A DNA string <i>s</i> of length at most 1000 bp.<br>
 * <b>Return</b>: The reverse complement <i>s<sup>c</sup></i> of <i>s</i>.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code AAAACCCGGT}
 * <p>
 * <b>Sample Output</b><br>
 * {@code ACCGGGTTTT}
 */
public class ProblemREVC implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/revc.txt");
        StringBuilder complement = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            switch (input.charAt(i)) {
                case 'A' -> complement.append('T');
                case 'T' -> complement.append('A');
                case 'C' -> complement.append('G');
                case 'G' -> complement.append('C');
            }
        }

        return new Result<>(complement.toString());
    }

    @Override
    public String getName() {
        return "Complementing a Strand of DNA";
    }
}
