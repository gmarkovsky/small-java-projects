package com.gmail.gbmarkovsky.es.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem29 implements EulerProblem {

	@Override
	public String solve() {
		Set<String> set = new HashSet<String>();
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				set.add(new BigInteger(Integer.toString(i)).pow(j).toString());
			}
		}
		return Integer.toString(set.size());
	}

}
