package com.gmail.gbmarkovsky.es.problems;

import java.util.HashMap;
import java.util.Map;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem243 implements EulerProblem {
	int pi = 2;
	static int[] primes = Util.primes(100);

	@Override
	public String solve() {
		double bound = 15499.0/94744.0;
		double rr = 100;
		
		while (rr > bound) {
			Map<Integer, Integer> next = next();
			rr = r(next);
			if (rr < bound) {
				return Integer.toString(eval(next));
			}
//			print(next);
//			System.out.println(" " + rr);
			for (int i = 2; i < primes[pi]; i++) {
				Map<Integer, Integer> nkk = merge(next, factorization(i));
				rr = r(nkk);
//				print(nkk);
//				System.out.println(" " + rr);
				if (rr < bound) {
					return Integer.toString(eval(nkk));
				}
			}
		}
		return "error";
	}
	
	private Map<Integer, Integer> factorization(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 0;
		int b = n/2 + 1;
		while (primes[i] <= b) {
			int k = 0;
			while(n % primes[i] == 0) {
				n = n / primes[i];
				k++;
			}
			if (k > 0)
				map.put(primes[i], k);
			i++;
		}
		return map;
	}
	
	private int eulerFi(int d, Map<Integer, Integer> map) {
		int res = 1;
		if (map.keySet().size() == 0) {
			return d - 1;
		}
		for (Integer i : map.keySet()) {
			res *= Math.pow(i, map.get(i)-1) * (i - 1);
		}
		return res;
	}
	
	private double r(Map<Integer, Integer> map) {
		double eulerFi = eulerFi(1, map);
		
		return eulerFi/(eval(map)-1);
	}
	
	private Map<Integer, Integer> next() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i <= pi; i++) {
			map.put(primes[i], 1);
		}
		pi++;
		return map;
	}
	
	private int eval(Map<Integer, Integer> map) {
		int res = 1;
		for (Integer i : map.keySet()) {
			res *= Math.pow(i, map.get(i));
		}
		return res;
	}
	
	private Map<Integer, Integer> merge(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>(map1);
		for (Integer i : map2.keySet()) {
			res.put(i, map1.get(i) + map2.get(i));
		}
		return res;
	}
}
