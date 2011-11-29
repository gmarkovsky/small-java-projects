package com.gmail.gbmarkovsky.es.problems;

import java.math.BigInteger;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem25 implements EulerProblem {
	public String solve() {
		BigInteger fn2 = new BigInteger("1");
		BigInteger fn1 = new BigInteger("1");
		BigInteger fn = fn2.add(fn1);
		int counter = 3;
		while(fn.toString().length() < 1000) {
			fn2 = fn1;
			fn1 = fn;
			fn = fn2.add(fn1);
			counter++;
		}
		//System.out.println(fn.toString());
		//System.out.println(fn.toString().length());
		return Integer.toString(counter);
	}
}
