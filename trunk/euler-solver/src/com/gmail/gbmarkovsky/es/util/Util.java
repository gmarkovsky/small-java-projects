package com.gmail.gbmarkovsky.es.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class Util {
	public static byte[] sieve(int n) {
		byte[] s = new byte[n];

		Arrays.fill(s, (byte) 1);
		
		s[0] = 0; // 1 - не простое число
		s[1] = 0; // 1 - не простое число

		for (int k = 2; k * k < n; k++) {
			if (s[k] == 1) {
				for (int l = k * k; l < n; l += k) {
					s[l] = 0;
				}
			}
		}
		return s;
	}
	
	public static void print(List<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}
	
	public static int[] primes(int n) {
		byte[] marks = sieve(n);
		int primesCounter = 0;
		for (int i = 2; i < marks.length; i++) {
			if (marks[i] == 1)
				primesCounter++;
		}
		
		int[] result = new int[primesCounter];
		int k = 0;
		for (int i = 2; i < marks.length; i++) {
			if (marks[i] == 1)
				result[k++] = i;
		}
		return result;
	}
	
	public static List<Integer> properDivisors(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0)
				result.add(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		primes(100);
	}
	
	public static int sum(List<Integer> list) {
		int result = 0;
		for (Integer integer : list) {
			result += integer;
		}
		return result;
	}
	
	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else if (b > a)
				b = b - a;
		}
		return a;

	}
	
	public static List<String> readWords(String filePath) {
		List<String> result = Lists.newArrayList();
		String lines = null;
		try {
			lines = Files.toString(new File(filePath), Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("Input data file not found!");
		}
			StringTokenizer tokenizer = new StringTokenizer(lines);
			while (tokenizer.hasMoreTokens()) {
				result.add(tokenizer.nextToken("\",\""));
			}
		
		return result;
	}
}
