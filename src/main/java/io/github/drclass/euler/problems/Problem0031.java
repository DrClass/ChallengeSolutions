package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * In the United Kingdom the currency is made up of pound (£) and pence (p).
 * There are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
 * <p>
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * <p>
 * How many different ways can £2 be made using any number of coins?
 */
public class Problem0031 implements Problem {
	private static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
	
	public Result<?> solve() {
        return new Result<>(combos(200, coins.length -1));
	}
	
	private static int combos(int amount, int c) {
        if (amount == 0 || c == 0) {
            return 1;
        } else if (coins[c] > amount) {
            return combos(amount, c - 1);
        } else {
            return combos(amount - coins[c], c) + combos(amount, c - 1);
        }
    }
}
