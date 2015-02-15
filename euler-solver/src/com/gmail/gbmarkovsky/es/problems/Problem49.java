package com.gmail.gbmarkovsky.es.problems;

import java.util.Arrays;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem49 implements EulerProblem {

	private int[] primes = Util.primes(10000);
	
	@Override
	public String solve() {
		int i = 0;
		while (primes[i] <= 1487) {
			i++;
		}
		primes = Arrays.copyOfRange(primes, i, primes.length);
		
		for (int j = 0; j < primes.length; j++) {
			for (int j2 = j + 1; j2 < primes.length; j2++) {
				for (int k = j2 + 1; k < primes.length; k++) {
					if (primes[k] - primes[j2] ==  primes[j2] - primes[j] &&
							primes[k] - primes[j2] == 3330 &&
							isPermutation(primes[k], primes[j2]) && 
							isPermutation(primes[j2], primes[j])) {
						return String.format("%s%s%s", primes[j], primes[j2], primes[k]) ;
					}
				}
			}
		}
		
		return "error";
	}

	private static boolean isPermutation(int n1, int n2) {
		String s1 = Integer.toString(n1);
		String s2 = Integer.toString(n2);
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) {
			if (!s1.contains(Character.toString(s2.charAt(i))))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new Problem49().solve());
	}
}
