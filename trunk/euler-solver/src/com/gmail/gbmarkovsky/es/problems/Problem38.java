package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem38 implements EulerProblem {
	@Override
	public String solve() {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 20; i++) {
			int[] nums = generateArray(i);
			for (int j = 1; j < 100000; j++) {
				String panDigital = panDigital(j, nums);
				if (panDigital != null) {
					int pd = Integer.parseInt(panDigital);
					if (pd > max)
						max = pd;
				}
			}
		}
		
		return Integer.toString(max);
	}

	private static final String panDigital(int n, int[] ns) {
		Set<Character> digits = new HashSet<Character>();
		for (int i = 0; i < ns.length; i++) {
			int t = n * ns[i];
			String s = Integer.toString(t);
			for (int j = 0; j < s.length(); j++) {
				char charAt = s.charAt(j);
				if (charAt == '0')
					return null;
				if (!digits.add(charAt)) {
					return null;
				}
			}
		}
		
		if (digits.size() != 9)
			return null;
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ns.length; i++) {
			int t = n * ns[i];
			builder.append(Integer.toString(t));
		}
		
		return builder.toString();
	}
	
	private static final int[] generateArray(int n) {
		int[] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = i + 1;
		}
		return res;
	}
}
