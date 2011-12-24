package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem187 implements EulerProblem {

	private static final int bound = 100000000;

	@Override
	public String solve() {
		int[] primes = Util.primes(bound/2);
		
		int sqrtN = 0;
		while(primes[sqrtN] < Math.sqrt(bound)) {
			sqrtN++;
		}
		
		long counter = pairs(sqrtN) + sqrtN;
		
		for (int i = sqrtN; i < primes.length; i++) {
			int j = 0;
			while (true) {
				long mul = (long) primes[i] * (long) primes[j];
				if (mul > bound)
					break;
				counter++;
				j++;
			}
		}
		return Long.toString(counter);
	}

	static long pairs(int n) {
		long result = 1;
		for (int i = n - 2 + 1; i <= n; i++) {
			result *= i;
		}
		return result/2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Problem187().solve());
	}
}
