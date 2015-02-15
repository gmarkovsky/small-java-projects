package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem41 implements EulerProblem {
	public String solve() {
		int[] X = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		while (!Util.isPrime(Integer.parseInt(print(X)))) {
			permute2(X);
			if (X[0] == 1 && X[X.length - 1] == X.length) {
				X = generate(X.length - 1);
			}
		}
		return print(X);
	}
	
	static int[] generate(int n) {
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = n - i;
		}
		return result;
	}
	
	static boolean permute2(int[] x) {
		int i = x.length - 2;
		while ((i >= 0) && (x[i] < x[i + 1])) {
			i--;
		}
		;
		if (i >= 0) {
			int j = i + 1;
			while ((j < x.length - 1) && (x[j + 1] < x[i])) {
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
	
	public static void main(String[] args) {
		System.out.println(new Problem41().solve());
	}
}
