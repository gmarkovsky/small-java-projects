package com.gmail.gbmarkovsky.es.problems;

import java.util.Arrays;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem36 implements EulerProblem {

	@Override
	public String solve() {
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			if (isPalindrom(Integer.toString(i).toCharArray())
					&& isPalindrom(Integer.toBinaryString(i).toCharArray())) {
				sum += i;
			}
		}
		return Integer.toString(sum);
	}

	private static final boolean isPalindrom(char[] s) {
		if (s.length < 2) {
			return true;
		} else if (s[0] == s[s.length - 1]) {
			if (s.length == 2)
				return true;
			else
				return isPalindrom(Arrays.copyOfRange(s, 1, s.length - 1));
		} else {
			return false;
		}
	}
}
