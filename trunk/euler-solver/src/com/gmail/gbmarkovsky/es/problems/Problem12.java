package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem12 implements EulerProblem {
	public String solve() {
		int triangle = 1;
		int i = 1;
		while (true) {
			if (divisorsCount(triangle) >= 500) {
				break;
			}
			triangle += ++i;
		}
		return Integer.toString(triangle);
	}

	static int divisorsCount(int n) {
		int divisors = 2;
		double root = Math.sqrt(n);
		for (int i = 2; i <= root; i++) {
			if (n % i == 0) {
				divisors += 2;
			}
		}
		return divisors;
	}
}
