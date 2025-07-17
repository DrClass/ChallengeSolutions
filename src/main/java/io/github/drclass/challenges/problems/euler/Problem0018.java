package io.github.drclass.challenges.problems.euler;

import io.github.drclass.challenges.api.Problem;
import io.github.drclass.challenges.api.Result;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.<br>
 * 3<br>
 * 7 4<br>
 * 2 4 6<br>
 * 8 5 9 3<br>
 * That is, 3 + 7 + 4 + 9 = 23.<br>
 * Find the maximum total from top to bottom of the triangle below:<br>
 * 75<br>
 * 95 64<br>
 * 17 47 82<br>
 * 18 35 87 10<br>
 * 20 04 82 47 65<br>
 * 19 01 23 75 03 34<br>
 * 88 02 77 73 07 63 67<br>
 * 99 65 04 28 06 16 70 92<br>
 * 41 41 26 56 83 40 80 70 33<br>
 * 41 48 72 33 47 32 37 16 94 29<br>
 * 53 71 44 65 25 43 91 52 97 51 14<br>
 * 70 11 33 28 77 73 17 78 39 68 17 57<br>
 * 91 71 52 38 17 14 91 43 58 50 27 29 48<br>
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31<br>
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23<br>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a
 * triangle containing one-hundred rows; it cannot be solved by brute force, and
 * requires a clever method! ;o)
 */
public class Problem0018 implements Problem {
	public Result<?> solve() {
		String triangle = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
		String[] s = triangle.split(" ");
		int n = (int) (Math.sqrt((8 * s.length) + 1) - 1) / 2;
		int[][] x = new int[n][n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			x[i] = new int[i + 1];
			for (int j = 0; j < (i + 1); j++) {
				x[i][j] = Integer.parseInt(s[index]);
				index++;
			}
		}
		for (int i = (n - 2); i >= 0; i--) {
			for (int j = 0; j < (x[i].length); j++) {
				if (x[i + 1][j] > x[i + 1][j + 1]) {
					x[i][j] += x[i + 1][j];
				} else {
					x[i][j] += x[i + 1][j + 1];
				}
			}
		}
		return new Result<>(x[0][0]);
	}
}
