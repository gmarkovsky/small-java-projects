package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem46 implements EulerProblem {
	static int[] primes = Util.primes(1000000);
	static Set<Integer> set = new HashSet<Integer>();
	
	static {
		for (int i = 0; i < primes.length; i++) {
			set.add(primes[i]);
		}
	}
	
	@Override
	public String solve() {
		int n = 9;
		while(true) {
			boolean solved = false;
			int i = 0;
			while(primes[i] < n && !solved) {
				int j = 1;
				while(j < n && !solved) {
					if (test(primes[i], j) == n) {
						solved = true;
					}
					j++;
				}
				i++;
			}
			if (!solved)
				return Integer.toString(n);
			n += 2;
			while (set.contains(n)) {
				n += 2;
			}
		}
	}

	static int test(int a, int b) {
		return a + 2 * b * b;
	}
}
