package io.github.drclass.challenges.problems.rosalind;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.List;

/**
 * The GC-content of a DNA string is given by the percentage of symbols in the string that are 'C' or 'G'. For example,
 * the GC-content of "AGCTATAG" is 37.5%. Note that the reverse complement of any DNA string has the same GC-content.
 * <p>
 * DNA strings must be labeled when they are consolidated into a database. A commonly used method of string labeling is
 * called FASTA format. In this format, the string is introduced by a line that begins with '&gt;', followed by some
 * labeling information. Subsequent lines contain the string itself; the first line to begin with '&gt;' indicates the
 * label of the next string.
 * <p>
 * In Rosalind's implementation, a string in FASTA format will be labeled by the ID "Rosalind_xxxx", where "xxxx"
 * denotes a four-digit code between 0000 and 9999.
 * <p>
 * <b>Given</b>: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).<br>
 * <b>Return</b>: The ID of the string having the highest GC-content, followed by the GC-content of that string.
 * Rosalind allows for a default error of 0.001 in all decimal answers unless otherwise stated.
 * <p>
 * <b>Sample Dataset</b><br>
 * <code>
 * &gt;Rosalind_6404<br>
 * CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC<br>
 * TCCCACTAATAATTCTGAGG<br>
 * &gt;Rosalind_5959<br>
 * CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT<br>
 * ATATCCATTTGTCAGCAGACACGC<br>
 * &gt;Rosalind_0808<br>
 * CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC<br>
 * TGGGAACCTGCGGGCAGTAGGTGGAAT
 * </code>
 * <p>
 * <b>Sample Output</b><br>
 * <code>
 * Rosalind_0808<br>
 * 60.919540
 * </code>
 */
public class ProblemGC implements Problem {
    @Override
    public Result<?> solve() {
        List<String> strings = ResourceUtils.loadResourceAsLines("rosalind/gc.txt");

        String id = "";
        double highestGC = 0;

        int readIndex = 0;
        do {
            String currentId = strings.get(readIndex);
            readIndex++;
            int gcCount = 0;
            int len = 0;
            while (strings.get(readIndex).charAt(0) != '>') {
                for (char c : strings.get(readIndex).toCharArray()) {
                    if (c == 'G' || c == 'C') {
                        gcCount++;
                    }
                }
                len += strings.get(readIndex).length();
                readIndex++;
                if (readIndex >= strings.size()) {
                    break;
                }
            }
            double gc = ((double) gcCount / len) * 100;
            if (gc > highestGC) {
                highestGC = gc;
                id = currentId.substring(1);
            }
        } while(readIndex < strings.size() - 1);

        return new Result<>(String.format("%s%n%g", id, highestGC));
    }

    @Override
    public String getName() {
        return "Computing GC Content";
    }
}
