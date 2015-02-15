package com.gmail.gbmarkovsky.es.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem23 implements EulerProblem {

	@Override
	public String solve() {
		List<Integer> abundant = new ArrayList<Integer>();
		for (int i = 1; i < 28124; i++) {
			if (Util.sum(Util.properDivisors(i)) > i)
				abundant.add(i);
		}
		boolean[] numbers = new boolean[28124];
		Arrays.fill(numbers, false);
		for (int i = 0; i < abundant.size(); i++) {
			for (int j = i; j < abundant.size(); j++) {
				int r = abundant.get(i) + abundant.get(j);
				if (r < 28124) {
					numbers[r] = true;
				}
			}
		}
		long res = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (!numbers[i])
				res += i;
		}
		return Long.toString(res);
	}
}
