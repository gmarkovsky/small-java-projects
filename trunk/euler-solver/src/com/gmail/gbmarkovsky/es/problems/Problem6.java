package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem6 implements EulerProblem {
	
	@Override
	public String solve() {
		long sum = (1 + 100) * 100 / 2;
		long sqSum = sum * sum;
		for (int i = 1; i <= 100; i++) {
			sqSum -= i * i;
		}
		return Long.toString(sqSum);
	}
}
