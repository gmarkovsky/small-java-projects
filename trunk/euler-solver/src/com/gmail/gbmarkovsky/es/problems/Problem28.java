package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem28 implements EulerProblem {

	@Override
	public String solve() {
		long result = 1;
		long current = 1;
		long add = 2;
		while (current < 1001 * 1001) {
			for (int i = 0; i < 4; i++) {
				current += add;
				result += current;
			}
			add += 2;
		}
		return Long.toString(result);
	}

}
