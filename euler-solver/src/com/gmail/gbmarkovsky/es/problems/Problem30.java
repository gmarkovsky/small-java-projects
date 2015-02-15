package com.gmail.gbmarkovsky.es.problems;

import java.util.HashMap;
import java.util.Map;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem30 implements EulerProblem {
	private static final Map<Integer, Integer> fifthPowers;

	static {
		fifthPowers = new HashMap<Integer, Integer>();
		fifthPowers.put(0, 0);
		fifthPowers.put(1, 1);
		fifthPowers.put(2, 32);
		fifthPowers.put(3, 243);
		fifthPowers.put(4, 1024);
		fifthPowers.put(5, 3125);
		fifthPowers.put(6, 7776);
		fifthPowers.put(7, 16807);
		fifthPowers.put(8, 32768);
		fifthPowers.put(9, 59049);
	}
	
	@Override
	public String solve() {
		int sum = 0;
		for (int i = 3; i < 1000000; i++) {
			if (fifthPowerSum(Integer.toString(i)) == i)
				sum += i;
		}
		return Integer.toString(sum);
	}

	public int fifthPowerSum(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += fifthPowers.get(Integer.parseInt(Character.toString(s.charAt(i))));
		}
		return res;
	}
}
