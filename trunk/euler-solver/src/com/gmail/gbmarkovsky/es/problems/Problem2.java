package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem2 implements EulerProblem {

	@Override
	public String solve() {
		long result = 2;
		int fn2 = 1;
		int fn1 = 2;
		int fn = 0;
		while (fn < 4000000) {
			fn = fn2 + fn1;
			if (fn % 2 == 0) {
				result += fn;
			}
			fn2 = fn1;
			fn1 = fn;
		}
		return Long.toString(result);
	}
}
