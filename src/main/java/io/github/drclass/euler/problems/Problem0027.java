package io.github.drclass.euler.problems;

import java.util.ArrayList;
import java.util.List;

import io.github.drclass.commons.math.Primes;
import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * Euler discovered the remarkable quadratic formula:<br>
 * <b><i>n</i><sup>2</sup> + <i>n</i> + 41</b>
 * <p>
 * It turns out that the formula will produce <b>40</b> primes for the
 * consecutive integer values <b>0 &lt;= <i>n</i> &lt;= 39</b>. However, when
 * <b><i>n</i> = 40</b>, <b>40<sup>2</sup> + 40 + 41 = 40 (40 + 1) + 41</b> is
 * divisible by <b>41</b>, and certainly when <b><i>n</i> = 41</b>,
 * <b>41<sup>2</sup> + 41 + 41</b> is clearly divisible by <b>41</b>.
 * <p>
 * The incredible formula <b><i>n</i><sup>2</sup> − 79<i>n</i> + 1601</b> was
 * discovered, which produces <b>80</b> primes for the consecutive values <b>0
 * &lt;= <i>n</i> &lt;= 79</b>. The product of the coefficients, <b>−79</b> and
 * <b>1601</b>, is <b>−126479</b>.
 * <p>
 * Considering quadratics of the form:<br>
 * <b><i>n</i><sup>2</sup> + <i>an</i> + <i>b</i></b>, where <b>|<i>a</i>| &lt;
 * 1000</b> and <b>|<i>b</i>| &lt;= 1000</b><br>
 * where <b>|<i>n</i>|</b> is the modulus/absolute value of <b><i>n</i></b><br>
 * e.g. <b>|11| = 11</b> and <b>|−4| = 4</b>
 * <p>
 * Find the product of the coefficients, <b><i>a</i></b> and <b><i>b</i></b>,
 * for the quadratic expression that produces the maximum number of primes for
 * consecutive values of <b><i>n</i></b>, starting with <b><i>n</i> = 0</b>.
 */
public class Problem0027 implements Problem {
	public Result<?> solve() {
		ArrayList<Integer> bestCoeff = new ArrayList<>(List.of(0, 0, 0)); // maxPrimes, a, b
		for (int a = -999; a < 1000; ++a) {
			for (int b = -1000; b <= 1000; ++b) {
				int n = 0;
				while (Primes.isPrime(n * n + a * n + b)) {
					bestCoeff = (++n > bestCoeff.get(0)) ? new ArrayList<>(List.of(n, a, b)) : bestCoeff;
				}
			}
		}
		return new Result<>(bestCoeff.get(1) * bestCoeff.get(2));
	}
}
