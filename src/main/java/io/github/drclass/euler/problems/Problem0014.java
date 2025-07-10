package io.github.drclass.euler.problems;

import io.github.drclass.euler.api.Problem;
import io.github.drclass.euler.api.Result;

/**
 * The following iterative sequence is defined for the set of positive
 * integers:<br>
 * n -&gt; n/2 (n is even)<br>
 * n -&gt; 3n+1 (n is odd)<br>
 * Using the rule above and starting with 13, we generate the following
 * sequence:<br>
 * 13 -&gt; 40 -&gt; 20 -&gt; 10 -&gt; 5 -&gt; 16 -&gt; 8 -&gt; 4 -&gt; 2 -&gt;
 * 1.<br>
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.<br>
 * Which starting number, under one million, produces the longest chain?<br>
 * NOTE: Once the chain starts the terms are allowed to go above one
 * million.<br>
 */
public class Problem0014 implements Problem {
	
	int limit = 1_000_000;
	int[] memo = new int[limit];
	
	public Result<?> solve() {
		int largestChain = 0;
		int largestStart = 0;
		for (int i = 1; i < limit; i++) {
			int chainLength = collatz(i);
			memo[i] = chainLength;
			if (chainLength > largestChain) {
				largestChain = chainLength;
				largestStart = i;
			}
		}
		return new Result<>(largestStart);
	}
	
	private int collatz(long start) {
		int chainSize = 0;
		while (start != 1) {
			if (start < limit && start > 0 && memo[(int) start] != 0) {
				return chainSize + memo[(int) start];
			}
			if (start % 2 == 0) {
				start /= 2;
			} else {
				start = 3 * start + 1;
			}
			chainSize++;
		}
		return chainSize;
	}
}
