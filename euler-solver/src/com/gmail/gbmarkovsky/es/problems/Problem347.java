package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem347 implements EulerProblem {
	private static final long bound = 10000000;
	private static final int[] primes = Util.primes((int) bound);
	
	@Override
	public String solve() {
		long sum = 0;
		for (int i = 0; i < primes.length; i++) {
			for (int j = i + 1; j < primes.length; j++) {
				long find = find(primes[i], primes[j]);
				sum = sum + find;
				if (find == 0)
					break;
			}		
		}
		return Long.toString(sum);
	}

	private long find(long a, long b) {
		if (a * b > bound) {
			return 0;
		}
		long max = 0;
		long aip = a;
		
		for (int ap = 1; ap < 100; ap++) {
			long bip = b;
			for (int bp = 1; bp < 100; bp++) {
				long d = aip * bip;
				if (d <= bound) {
					if (d > max) {
						max = d;
					}
				} else {
					break;
				}
				bip = bip * b;
			}
			
			if(aip * b > bound)
				break;
			aip = aip * a;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Problem347().solve());
	}
}
