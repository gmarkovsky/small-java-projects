package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem50 implements EulerProblem {
	private static final int border = 1000000;
	
	private byte[] marks = Util.sieve(border);
	
	@Override
	public String solve() {
		int[] primes = Util.primes(border/2);
		int max = Integer.MIN_VALUE;
		int prime = 0;

		for (int i = 0; i < primes.length; i++) {
			int sum = primes[i];
			int j = i + 1;
			while ( j < primes.length && sum < border - primes[j]) {
				sum += primes[j];
				if (isPrime(sum)) {
					if (j - i > max) {
						max = j - i;
						prime = sum;
					}
				}
				j++;
			}
		}
		return Integer.toString(prime);
	}
	
	boolean isPrime(int n) {
		return (marks[n] == 1);
	}
}
