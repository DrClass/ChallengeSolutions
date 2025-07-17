package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * A string is simply an ordered collection of symbols selected from some alphabet and formed into a word; the length of
 * a string is the number of symbols that it contains.
 * <p>
 * An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T') is
 * "ATGCTTCAGAAAGGTCTTACG."
 * <p>
 * <b>Given</b>: A DNA string s of length at most 1000 nt.<br>
 * <b>Return</b>: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C',
 * 'G', and 'T' occur in s.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC}
 * <p>
 * <b>Sample Output</b><br>
 * {@code 20 12 17 21}
 */
public class ProblemDNA implements Problem {
    @Override
    public Result<?> solve() {
        String dna = ResourceUtils.loadResourceAsString("rosalind/dna.txt");
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        char[] dnaCharArray = dna.toCharArray();
        for (char dnaChar : dnaCharArray) {
            switch (dnaChar) {
                case 'A' -> a++;
                case 'C' -> c++;
                case 'G' -> g++;
                case 'T' -> t++;
                default -> {
                    // This should not be reachable
                }
            }
        }

        String answer = String.format("%d %d %d %d", a, c, g, t);

        return new Result<>(answer);
    }

    @Override
    public String getName() {
        return "Counting DNA Nucleotides";
    }
}
