package com.gmail.gbmarkovsky.es.problems;

import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.base.Strings;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Bytes;

public class Problem43 implements EulerProblem {
	private static ListMultimap<Integer, String> numbers = LinkedListMultimap.create();
	
	private static List<Integer> ds = Lists.reverse(Lists.newArrayList(2, 3, 5, 7, 11, 13, 17));
	
	static {
		for (Integer i : ds) {
			int l = i;
			while (l < 999) {
				String padStart = Strings.padStart(Integer.toString(l), 3, '0');
				if (Sets.newHashSet(Bytes.asList(padStart.getBytes())).size() == 3) {
					numbers.put(i, padStart);
				}
				l+=i;
			}
		}
	}

	private List<String> getByTemplate(int n, String t) {
		List<String> list = numbers.get(n);
		List<String> res = Lists.newArrayList();
		for (String string : list) {
			if (string.substring(1).equals(t))
				res.add(string);
		}
		return res;
	}

	private static boolean isPretend(String s) {
		return Sets.newHashSet(Bytes.asList(s.getBytes())).size() == s.length();
	}
	
	@Override
	public String solve() {
		for (String i : numbers.get(17)) {
			calc(i, 1);
		}
		return null;
	}

	public void calc(String s, int n) {
		if (n < ds.size()) {
			List<String> byTemplate = getByTemplate(ds.get(n),
					s.substring(0, 2));
			for (String string : byTemplate) {
				String concat = string.substring(0, 1).concat(s);
				if (isPretend(concat))
					calc(concat, n + 1);
			}
		} else {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Problem43().solve());
	}
}
