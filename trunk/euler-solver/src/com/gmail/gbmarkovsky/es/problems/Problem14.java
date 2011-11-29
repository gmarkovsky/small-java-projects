package com.gmail.gbmarkovsky.es.problems;

import java.util.Map;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.collect.Maps;

public class Problem14 implements EulerProblem {
	
	@Override
	public String solve() {
		int max = Integer.MIN_VALUE;
		int imax = 0;
		Map<Long, Integer> cache = Maps.newHashMap();
		cache.put(1L, 1);
		for (int i = 2; i < 1000000; i++) {
			long c = i;
			int counter = 0;
			while (c != 1) {
				if (!cache.containsKey(c)) {
					c = function(c);
					counter++;
				} else {
					counter += cache.get(c);
					break;
				}
			}
			cache.put((long) i, counter);
			//System.out.println(i + " " + counter);
			if (counter > max) {
				max = counter;
				imax = i;
			}
		}
		return Integer.toString(imax);
	}
	
	static long function(long n) {
		if (n % 2 == 0) {
			return n/2;
		} else {
			return 3 * n + 1;
		}
	}
	
	static int check(long x) {
		int counter = 1;
		while (x != 1) {
			if (x < 0) {
				System.out.println("");
			}
			x = function(x);
			counter++;
		}
		return counter;
	}
}
