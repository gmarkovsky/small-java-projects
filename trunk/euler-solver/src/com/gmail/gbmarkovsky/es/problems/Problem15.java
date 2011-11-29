package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem15 implements EulerProblem {
	private static int size = 20;

	@Override
	public String solve() {
		return Long.toString(countWays(size));
	}

	static long countWays(int n) {
		int size = n + 1;
		long[][] field = new long[size][size];
		field[0][0] = 1;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (i - j == 0) {
					field[i - j][j] = field[i - j][j - 1];
				} else if (j == 0) {
					field[i - j][j] = field[i - j - 1][j];
				} else {
					field[i - j][j] = field[i - j - 1][j] + field[i - j][j - 1];
				}
			}
		}

		for (int i = 1; i < size; i++) {
			for (int j = i; j < size; j++) {
				field[j][size - j + i - 1] = field[j - 1][size - j + i - 1]
						+ field[j][size - j + i - 1 - 1];
			}
		}

		return field[size - 1][size - 1];
	}
}
