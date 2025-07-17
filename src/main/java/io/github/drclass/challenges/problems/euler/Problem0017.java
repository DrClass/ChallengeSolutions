package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.<br>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?<br>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */
public class Problem0017 implements Problem {
	
	String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	                          "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public Result<?> solve() {
		int result = 0;
		for (int i = 1; i < 1001; i++) {
			result += numberToWords(i).length();
		}
		return new Result<>(result);
	}
	
	private String numberToWords(int num) {
		if (num < 20) {
	        return units[num];
		}
		else if (num < 100) {
	        return tens[num / 10] + units[num % 10];
		}
		else if (num < 1000) {
	        if (num % 100 == 0) {
	            return units[num / 100] + "hundred";
	        }
	        else {
	            return units[num / 100] + "hundredand" + numberToWords(num % 100);
	        }
		}
		else if (num == 1000) {
			return "onethousand";
		}
		return null;
	}
}
