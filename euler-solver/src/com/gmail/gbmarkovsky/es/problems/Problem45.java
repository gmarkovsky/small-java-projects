package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem45 implements EulerProblem {
	private int ti = 1;
	private int pi = 1;
	private int hi = 1;
	
	private long t = 1;
	private long p = 1;
	private long h = 1;
	
	@Override
	public String solve() {
		long triangle = 1;
		long pentagonal = 1;
		long hexagonal = 1;
		while (true) {
			hexagonal = nextHexagonal();
			while (pentagonal < hexagonal) {
				pentagonal = nextPentagonal();
			}
			while (triangle < hexagonal) {
				triangle = nextTriangle();
			}
			if ((triangle == hexagonal) && (hexagonal == pentagonal) && triangle != 40755) 
				return Long.toString(triangle);
		}
	}

	long nextTriangle() {
		t = t + ti + 1;
		ti++;
		return t;
	}
	
	long nextPentagonal() {
		p = p + 3 * pi + 1;
		pi++;
		return p;
	}
	
	long nextHexagonal() {
		h = h + 4 * hi + 1;
		hi++;
		return h;
	}
}
