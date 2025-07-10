package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

import java.math.BigInteger;

/**
 * The fraction <b>49/98</b> is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that <b>49/98 = 4/8</b>, which is correct, is obtained by cancelling the <b>9</b>s.
 * <p>
 * We shall consider fractions like, <b>30/50 = 3/5</b>, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two
 * digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem0033 implements Problem {
    @Override
    public Result<?> solve() {
        int numProduct = 1;
        int denProduct = 1;

        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                if (numerator % 10 == 0 && denominator % 10 == 0) {
                    continue; // trivial
                }

                int numTens = numerator / 10;
                int numOnes = numerator % 10;
                int denTens = denominator / 10;
                int denOnes = denominator % 10;

                // Check all digit cancellation cases
                if (numOnes == denTens && denOnes != 0) {
                    if (numerator * denOnes == denominator * numTens) {
                        numProduct *= numerator;
                        denProduct *= denominator;
                    }
                } else if (numTens == denOnes && denTens != 0) {
                    if (numerator * denTens == denominator * numOnes) {
                        numProduct *= numerator;
                        denProduct *= denominator;
                    }
                }
            }
        }

        // Reduce fraction
        int gcd = BigInteger.valueOf(numProduct).gcd(BigInteger.valueOf(denProduct)).intValue();
        denProduct /= gcd;

        return new Result<>(denProduct);
    }
}
