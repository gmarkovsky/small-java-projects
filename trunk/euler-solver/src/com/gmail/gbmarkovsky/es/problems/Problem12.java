package com.gmail.gbmarkovsky.es.problems;

public class Problem12 {
	public static void main(String[] args) {
		int c = 2;
		while (true) {
			long triangle = triangle(c);
			int dividersCount = dividersCount(triangle);
			if (dividersCount > 100)
				System.out.println(c + " " + triangle + " " + dividersCount);
			if (dividersCount > 500) {
				return;
			}
			c++;
		}
	}

	static long triangle(int n) {
		return ((1 + n) * n) / 2;
	}

	static int dividersCount(long n) {
		int counter = 0;
		for (long i = 1; i <= n/2; i++) {
			if (n % i == 0)
				counter++;
		}
		return ++counter;
	}
}
