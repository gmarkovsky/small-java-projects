package com.gmail.gbmarkovsky.es.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem21 implements EulerProblem {
	@Override
	public String solve() {
		boolean[] cache = new boolean[10000];
		Arrays.fill(cache, false);
		int result = 0;
		for (int i = 1; i < 10000; i++) {
			if (!cache[i]) {
				int sum = sum(properDivisors(i));
				if (i == sum(properDivisors(sum)) && i != sum) {
					cache[i] = true;
					cache[sum] = true;
					result += i;
					result += sum;
				}
			}
		}
		return Integer.toString(result);
	}
	
	static List<Integer> properDivisors(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0) {
				result.add(i);
			}
		}
		return result;
	}
	
	static int sum(List<Integer> list) {
		int summa = 0;
		for (Integer integer : list) {
			summa += integer;
		}
		return summa;
	}
}
