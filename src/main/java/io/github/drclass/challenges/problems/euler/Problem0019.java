package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.<br>
 * <ul>
 * <li>1 Jan 1900 was a Monday.</li>
 * <li>Thirty days has September,<br>
 * April, June and November.<br>
 * All the rest have thirty-one,<br>
 * Saving February alone,<br>
 * Which has twenty-eight, rain or shine.<br>
 * And on leap years, twenty-nine.</li>
 * <li>A leap year occurs on any year evenly divisible by 4, but not on a
 * century unless it is divisible by 400.</li>
 * </ul>
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem0019 implements Problem {
	public Result<?> solve() {
		int sunday = 0;
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 1; month <= 12; month++) {
				if ((1 + 13 * ((month + 10) % 12 + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 == 0) {
					sunday++;
				}
			}
		}
		return new Result<>(sunday);
	}
}
