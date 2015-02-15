package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.gmail.gbmarkovsky.es.util.Util;

public class Problem33 implements EulerProblem {

	@Override
	public String solve() {
		int mn = 1;
		int md = 1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					int n = 10 * j + i;
					int d = 10 * k + i;
					
					if (n * k == d * j && n < d) {
						mn *= n;
						md *= d;
					}
					
					n = 10 * j + i;
					d = k + 10 * i;
					
					if (n * k == d * j && n < d) {
						mn *= n;
						md *= d;
					}
					
					n = j + 10 * i;
					d = 10 * k + i;
					
					if (n * k == d * j && n < d) {
						mn *= n;
						md *= d;
					}
					
					n = j + 10 * i;
					d = k + 10 * i;
					
					if (n * k == d * j && n < d) {
						mn *= n;
						md *= d;
					}
				}	
			}
		}
		return Integer.toString(md / Util.gcd(mn, md));
	}
}
