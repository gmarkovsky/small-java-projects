package com.gmail.gbmarkovsky.es.problems;

import java.math.BigInteger;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem20 implements EulerProblem {
	public String solve() {
		String fact = fact(100).toString();
		int res = 0;
		for (int i = 0; i < fact.length(); i++) {
			res += Integer.parseInt(Character.toString(fact.charAt(i)));
		}
		return Integer.toString(res);
	}
	
	static BigInteger fact(int n) {
		BigInteger result = new BigInteger("1");
		while (n > 1) {
			result = result.multiply(new BigInteger(Integer.toString(n)));
			n--;
		}
		return result;
	}
}
