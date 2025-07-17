package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.ResourceUtils;
import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

import java.util.HashSet;
import java.util.Set;

/**
 * The <b><i><n</i></b>th term of the sequence of triangle numbers is given by, <b><i>t<sub>n</sub></i> = 1/2
 * <i>n</i>(<i>n</i> + 1)</b>; so the first ten triangle numbers are:<br>
 * <b>1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...</b>
 * <p>
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we
 * form a word value. For example, the word value for SKY is <b>18 + 11 + 25 = 55 = <i>t</i><sub>10</sub></b>. If the
 * word value is a triangle number then we shall call the word a triangle word.
 * <p>
 * Using <b>words.txt</b>, a 16K text file containing nearly two-thousand common English words, how many are triangle
 * words?
 */
public class Problem0042 implements Problem {
    @Override
    public Result<?> solve() {
        String[] words = ResourceUtils.loadResourceAsString("words.txt").split("\",\"");
        // Fix the first and last word having an extra " in them
        // There is probably a nice way to do this, but I just copied the code from problem 22
        words[0] = words[0].replace("\"", "");
        words[words.length - 1] = words[words.length - 1].replace("\"", "");

        Set<Integer> triangles = new HashSet<>();
        // Probably don't need to go this high, but just in case we do
        for (int i = 1; i < 5000; i++) {
            triangles.add((i + 1) * i / 2);
        }

        int foundTriangles = 0;
        for (String word : words) {
            int value = word.toLowerCase().chars().map(c -> c - 96).sum();
            if (triangles.contains(value)) {
                foundTriangles++;
            }
        }

        return new Result<>(foundTriangles);
    }
}
