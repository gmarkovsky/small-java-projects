package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem1 implements EulerProblem {

	@Override
	public String solve() {
		long result = 0;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				result += i;
			}
		}
		return Long.toString(result);
	}
}
