package com.gmail.gbmarkovsky.es.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem22 implements EulerProblem {
	@Override
	public String solve() {
		List<String> read = Util.readWords("res/22.txt");
		Collections.sort(read, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		int c = 1;
		long res = 0;
		for (String string : read) {
			res += c * score(string);
			c++;
		}
		return Long.toString(res);
	}
	
	int score(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			
			result += Character.getNumericValue(s.charAt(i)) - 9;
		}
		return result;
	}
}
