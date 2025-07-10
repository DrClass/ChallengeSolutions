package io.github.drclass.euler.problems;

import java.io.IOException;
import java.util.Arrays;

import io.github.drclass.euler.ResourceUtils;
import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * Using names.txt, a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical
 * position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 * 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class Problem0022 implements Problem {
	public Result<?> solve() {
		String namesString = ResourceUtils.loadResourceAsString("names.txt");
		String[] names = namesString.split("\",\"");
		// Fix the first and last name having an extra " in them
		names[0] = names[0].replace("\"", "");
		names[names.length - 1] = names[names.length - 1].replace("\"", "");
		
		Arrays.sort(names);
		long total = 0;
		for (int i = 0; i < names.length; i++) {
			total += names[i].chars().map(x -> x - 64).sum() * (i + 1);
		}
		return new Result<>(total);
	}
}
