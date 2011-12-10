package com.gmail.gbmarkovsky.es.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem37 implements EulerProblem {
	
	
	@Override
	public String solve() {
		int[] primes = Util.primes(1000000);
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < primes.length; i++) {
			set.add(primes[i]);
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] < 10)
				continue;
			List<Integer> rotes = trunks(primes[i]);
			if (check(rotes, set)) {
				sum += primes[i];
			}
		}
		return Integer.toString(sum);
	}
	
	private static final boolean check(List<Integer> rotes, Set<Integer> set) {
		for (Integer i : rotes) {
			if (!set.contains(i))
				return false;
		}
		return true;
	}
	
	private static final List<Integer> trunks(int n) {
		String rt = Integer.toString(n);
		String lt = new String(rt);
		int len = rt.length();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < len - 1; i++) {
			rt = rt.substring(0, rt.length()-1);
			lt = lt.substring(1, lt.length());
			result.add(Integer.parseInt(rt));
			result.add(Integer.parseInt(lt));
		}
		return result;
	}
}
