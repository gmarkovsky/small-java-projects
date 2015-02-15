package com.gmail.gbmarkovsky.es.problems;

import java.util.Arrays;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem7 implements EulerProblem {
	@Override
	public String solve() {
		byte[] s = sieve(2000000);
		long result = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == 1) {
				result ++;
				if (result == 10001) {
					return Long.toString(i);
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
