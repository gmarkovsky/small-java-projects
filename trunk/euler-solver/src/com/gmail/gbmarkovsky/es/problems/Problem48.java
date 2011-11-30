package com.gmail.gbmarkovsky.es.problems;

import java.math.BigInteger;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem48 implements EulerProblem {

	@Override
	public String solve() {
		String result = "0";
		for (int i = 1; i <= 1000; i++) {
			result = sum(result, selfPower(i));
		}
		return result;
	}

	String selfPower(int n) {
		String bs = Integer.toBinaryString(n);
		String res = Integer.toString(n);
		String x = Integer.toString(n);
		for (int i = 1; i < bs.length(); i++) {
			res = multiple(res, res);
			if ('1' == bs.charAt(i)) {
				res = multiple(res, x);
			}
		}

		return res;
	}

	String multiple(String s1, String s2) {
		BigInteger result = new BigInteger(s1);
		result = result.multiply(new BigInteger(s2));
		String string = result.toString();
		if (string.length() > 10) {
			return string.substring(string.length() - 10, string.length());
		} else {
			return string;
		}
	}
	
	String sum(String s1, String s2) {
		BigInteger result = new BigInteger(s1);
		result = result.add(new BigInteger(s2));
		String string = result.toString();
		if (string.length() > 10) {
			return string.substring(string.length() - 10, string.length());
		} else {
			return string;
		}
	}
}
