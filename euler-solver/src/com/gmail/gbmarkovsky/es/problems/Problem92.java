package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem92 implements EulerProblem {
	@Override
	public String solve() {
		long result = 0;
		
		for (int i = 1; i < 10000000; i++) {
			int trace = trace(i);
			
			if (trace == 89)
				result++;
		}
		
		return String.valueOf(result);
	}
	
	public int trace(int start) {
		while (start != 1 && start != 89) {
			start = next(start);
		}
		
		return start;
	}
	
	public int next(int n) {
		int result = 0;
		while (n > 0) {
			int e = n % 10;
			n = n / 10;
			result += e * e;
		}
		return result;
	}
}
