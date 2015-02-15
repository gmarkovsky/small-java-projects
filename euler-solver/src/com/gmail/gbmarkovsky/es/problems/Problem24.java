package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem24 implements EulerProblem {
	public String solve() {
		int[] X = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 1;
		while (permute2(X)) {
			i++;
			if (i == 1000000) {
				return print(X);
			}
		}
		return "error";
	}

	static boolean permute2(int[] x) {
		int i = x.length - 2;
		while ((i >= 0) && (x[i] > x[i + 1])) {
			i--;
		}
		;
		if (i >= 0) {
			int j = i + 1;
			while ((j < x.length - 1) && (x[j + 1] > x[i])) {
				j++;
			}
			int tmp = x[i];
			x[i] = x[j];
			x[j] = tmp;
			for (j = i + 1; j <= (x.length + i) / 2; j++) {

				int tp = x[j];
				x[j] = x[x.length - j + i];
				x[x.length - j + i] = tp;
			}
			;
		} else {
			return false;
		}
		return true;
	}

	static String print(int[] a) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			builder.append(Integer.toString(a[i]));
		}
		return builder.toString();
	}
}
