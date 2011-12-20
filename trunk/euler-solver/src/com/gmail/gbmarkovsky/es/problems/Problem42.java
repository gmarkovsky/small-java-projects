package com.gmail.gbmarkovsky.es.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem42 implements EulerProblem {

	private static Set<Integer> triangles = new HashSet<Integer>();
	
	static {
		int newxtTriangle = 1;
		int i = 2;
		while (newxtTriangle < 1400) {
			triangles.add(newxtTriangle);
			newxtTriangle += i;
			i++;
		}
	}
	
	@Override
	public String solve() {
		List<String> read = Util.readWords("res/42.txt");
		int counter = 0;
		for (String string : read) {
			if (triangles.contains(score(string))) {
				counter++;
			}
		}
		return Long.toString(counter);
	}
	
	int score(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			
			result += Character.getNumericValue(s.charAt(i)) - 9;
		}
		return result;
	}
}
