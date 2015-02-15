package com.gmail.gbmarkovsky.es.problems;

import java.util.HashMap;
import java.util.Map;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem17 implements EulerProblem {

	@Override
	public String solve() {
		long sum = 0;
		for (int i = 1; i < 1000; i++) {
			sum += count(convert(i));
		}
		sum += count("one thousand");
		return Long.toString(sum);
	}
	
	public String convert(int n) {
		if (n <= 10) {
			return ones.get(n);
		} else if ((11 <= n) && (n <= 19)) {
			return hk.get(n);
		} else {
			String s = Integer.toString(n);
			s = new StringBuilder(s).reverse().toString(); 
			int hundreds = (s.length() > 2) ? Integer.parseInt(new Character(s.charAt(2)).toString()) : 0;
			int tens = Integer.parseInt(new Character(s.charAt(1)).toString());
			int ones = Integer.parseInt(new Character(s.charAt(0)).toString());
			StringBuilder result = new StringBuilder();
			if (hundreds > 0) {
				result.append(this.ones.get(hundreds));
				result.append(" hundred");
			}
			if (tens == 0 && ones == 0) {
				return result.toString();
			}
			if (tens == 0 && ones != 0) {
				result.append(" and " + this.ones.get(ones));
				return result.toString();
			}
			if ((tens * 10 + ones < 20) && (tens * 10 + ones >= 10)) {
				result.append(" and " + hk.get(tens * 10 + ones));
				return result.toString();
			}
			if (hundreds > 0)
			result.append(" and " + this.tens.get(tens));
			else
			result.append(this.tens.get(tens));
			if (ones != 0)
				result.append("-" + this.ones.get(ones));
			
			return result.toString();
		}
	}
	
	public int count(String s) {
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				counter++;
		}
		return counter;
	}
	
	private Map<Integer, String> ones = new HashMap<Integer, String>();
	{
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eigth");
		ones.put(9, "nine");
		ones.put(10, "ten");
	}
	
	private Map<Integer, String> hk = new HashMap<Integer, String>();
	{
		hk.put(10, "ten");
		hk.put(11, "eleven");
		hk.put(12, "twelve");
		hk.put(13, "thirteen");
		hk.put(14, "fourteen");
		hk.put(15, "fifteen");
		hk.put(16, "sixteen");
		hk.put(17, "seventeen");
		hk.put(18, "eighteen");
		hk.put(19, "nineteen");
	}
	
	private Map<Integer, String> tens = new HashMap<Integer, String>();
	{
		tens.put(2, "twenty");
		tens.put(3, "thirty");
		tens.put(4, "forty");
		tens.put(5, "fifty");
		tens.put(6, "sixty");
		tens.put(7, "seventy");
		tens.put(8, "eighty");
		tens.put(9, "ninety");
	}
}
