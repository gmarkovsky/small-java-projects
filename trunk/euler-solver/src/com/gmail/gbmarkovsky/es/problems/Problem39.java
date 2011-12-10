package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem39 implements EulerProblem {

	@Override
	public String solve() {
		int max = Integer.MIN_VALUE;
		int val = 0;
		for (int i = 3; i <= 1000; i++) {
			Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
			for (int j = 1; j < i; j++) {
				for (int k = 1; k < i - j; k++) {
					int l = i - j - k;
					if (isTriangle(j, k, l)) {
						Set<Integer> dd = new HashSet<Integer>();
						dd.add(j);
						dd.add(k);
						dd.add(l);
						sets.add(dd);
					}
				}
			}
			if (sets.size() > max) {
				max = sets.size();
				val = i;
			}
		}
		return Integer.toString(val);
	}

	private static final boolean isTriangle(int a, int b, int c) {
		return a*a + b*b == c*c;
	}
}
