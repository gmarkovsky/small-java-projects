package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem4 implements EulerProblem {
	static boolean isPalindrom(int n) {
		return isPalindrom(Integer.toString(n));
	}
	
	static boolean isPalindrom(String s) {
		if (s.isEmpty()) {
			return true;
		} else if (s.length() == 1) {
			return true;
		} else if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrom(s.substring(1, s.length() - 1));
		} else {
			return false;
		}
	}

	@Override
	public String solve() {
		int[][] field = new int[1000][1000];
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = i * j;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (isPalindrom(field[i][j])) {
					if (max < field[i][j]) {
						max = field[i][j];
					}
				}
			}
		}
		return Integer.toString(max);
	}
}
