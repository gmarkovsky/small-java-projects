package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem27 implements EulerProblem {
	static int[] primes = Util.primes(10000000);
	static Set<Integer>  primesSet = new HashSet<Integer>();
	static {
		for (int i = 0; i < primes.length; i++) {
			primesSet.add(primes[i]);
		}
	}
	
	
	@Override
	public String solve() {
		int max = Integer.MIN_VALUE;
		int av = 0;
		int bv = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int test = test(a, b);
				if (test > max) {
					max = test;
					av = a;
					bv = b;
				}
			}
		}
		return Integer.toString(av * bv);
	}

	static boolean isPrime(int n) {
		return primesSet.contains(n);
	}
	
	static int function(int a, int b, int n) {
		return n * n + a * n + b;
	}
	
	static int test(int a, int b) {
		int i = 0;
		while(isPrime(function(a, b, i))) {
			i++;
		}
		return i;
	}
}
