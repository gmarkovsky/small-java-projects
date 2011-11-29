package com.gmail.gbmarkovsky.es.problems;

import java.util.Arrays;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem3 implements EulerProblem {
	@Override
	public String solve() {
		long source = 600851475143L;

		int sqrt = (int) Math.sqrt(source);
		byte[] res = sieve(sqrt);
		for (int i = res.length - 1; i > 0; i--) {
			if (res[i] == 1) {
				if (source % i == 0) {
					return Integer.toString(i);
				}
			}
		}
		return "error";
	}

	static byte[] sieve(int n) {
		byte[] s = new byte[n];

		Arrays.fill(s, (byte) 1);

		s[0] = 0; // 1 - не простое число
		s[1] = 0; // 1 - не простое число

		for (int k = 2; k * k < n; k++) {
			if (s[k] == 1) {
				for (int l = k * k; l < n; l += k) {
					s[l] = 0;
				}
			}
		}
		return s;
	}
}
