package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;
import io.github.drclass.challenges.problems.rosalind.utils.Codon;

/**
 * The 20 commonly occurring amino acids are abbreviated by using 20 letters from the English alphabet (all letters
 * except for B, J, O, U, X, and Z). Protein strings are constructed from these 20 symbols. Henceforth, the term genetic
 * string will incorporate protein strings along with DNA strings and RNA strings.
 * <p>
 * The RNA codon table dictates the details regarding the encoding of specific codons into the amino acid alphabet.
 * <p>
 * <b>Given</b>: An RNA string <b><i>s</i></b> corresponding to a strand of mRNA (of length at most 10 kbp).<br>
 * <b>Return</b>: The protein string encoded by <b><i>s</i></b>.
 * <p>
 * <b>Sample Dataset</b><br>
 * {@code AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA}
 * <p>
 * <b>Sample Output</b><br>
 * {@code MAMAPRTEINSTRING}
 */
public class ProblemPROT implements Problem {
    @Override
    public Result<?> solve() {
        String input = ResourceUtils.loadResourceAsString("rosalind/prot.txt");
        StringBuilder proteinString = new StringBuilder();
        for (int i = 0; i < input.length(); i += 3) {
            Codon protein = Codon.fromNucleotides(input.substring(i, i + 3));
            if (protein != Codon.STOP) {
                proteinString.append(protein.name());
            }
        }
        return new Result<>(proteinString.toString());
    }

    @Override
    public String getName() {
        return "Translating RNA into Protein";
    }
}
