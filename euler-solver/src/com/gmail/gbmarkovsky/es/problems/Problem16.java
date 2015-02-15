package com.gmail.gbmarkovsky.es.problems;

import java.util.List;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.collect.Lists;

public class Problem16 implements EulerProblem {

	@Override
	public String solve() {
		List<Byte> number = Lists.newArrayList();
		number.add(Byte.valueOf((byte) 1));
		for (int i = 0; i < 1000; i++) {
			doubling(number);
		}
		long sum = 0;
		for (Byte digit : number) {
			sum += digit;
		}
		return Long.toString(sum);
	}

	
	static void doubling(List<Byte> list) {
		byte carry = 0;
		for (int i = 0; i < list.size(); i++) {
			byte digit = list.get(i);
			byte sum = (byte) (digit + digit + carry);
			if (sum > 9) {
				carry = 1;
				list.set(i, (byte) (sum % 10));
			} else {
				carry = 0;
				list.set(i, sum);
			}
		}
		if (carry != 0) {
			list.add(carry);
		}
	}
}
