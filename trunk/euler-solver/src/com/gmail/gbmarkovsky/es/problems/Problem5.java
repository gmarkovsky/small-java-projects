package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem5 implements EulerProblem {
	
	@Override
	public String solve() {
		int x = 19 * 17 * 13 * 11 * 7 * 5 * 3 * 3 * 2 * 2 * 2 * 2;
		return Integer.toString(x);
	}
}
