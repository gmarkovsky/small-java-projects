package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem9 implements EulerProblem {
	
	@Override
	public String solve() {
		for (int a = 0; a < 1000; a++) {
			for (int b = 0; b < 1000; b++) {
				int c = 1000 - a - b;
				if (a*a + b*b == c*c) {
					if ((a < b) && (b < c))
					return Integer.toString(a * b * c);
				}
			}
		}
		return "error";
	}
}
