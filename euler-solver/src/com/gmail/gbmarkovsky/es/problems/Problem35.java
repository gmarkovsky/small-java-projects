package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem35 implements EulerProblem {
	
	
	@Override
	public String solve() {
		int[] primes = Util.primes(1000000);
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> res = new HashSet<Integer>();
		for (int i = 0; i < primes.length; i++) {
			set.add(primes[i]);
		}
		for (int i = 0; i < primes.length; i++) {
			int[] rotes = rotate(primes[i]);
			if (check(rotes, set)) {
				for (int j = 0; j < rotes.length; j++) {
					res.add(rotes[j]);
				}
			}
		}
		return Integer.toString(res.size());
	}
	
	private static final boolean check(int[] ns, Set<Integer> set) {
		for (int i = 0; i < ns.length; i++) {
			if (!set.contains(ns[i]))
				return false;
		}
		return true;
	}
	
	private static final int[] rotate(int n) {
		String s = Integer.toString(n);
		int[] result = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			result[i] = Integer.parseInt(s);
			s = rot(s);
		}
		return result;
	}
	
	private static final String rot(String s) {
		StringBuilder builder = new StringBuilder(s);
		builder.append(builder.charAt(0));
		builder.deleteCharAt(0);
		return builder.toString();
	}
}
