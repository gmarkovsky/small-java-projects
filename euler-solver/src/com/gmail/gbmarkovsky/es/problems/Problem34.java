package com.gmail.gbmarkovsky.es.problems;

import java.util.HashMap;
import java.util.Map;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem34 implements EulerProblem {
	private static final Map<Integer, Integer> facts;

	static {
		facts = new HashMap<Integer, Integer>();
		facts.put(0, 1);
		facts.put(1, 1);
		facts.put(2, 2);
		facts.put(3, 6);
		facts.put(4, 24);
		facts.put(5, 120);
		facts.put(6, 720);
		facts.put(7, 5040);
		facts.put(8, 40320);
		facts.put(9, 362880);
	}
	
	@Override
	public String solve() {
		int sum = 0;
		for (int i = 3; i < 1000000; i++) {
			if (factSum(Integer.toString(i)) == i)
				sum += i;
		}
		return Integer.toString(sum);
	}

	public int factSum(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += facts.get(Integer.parseInt(Character.toString(s.charAt(i))));
		}
		return res;
	}
}
