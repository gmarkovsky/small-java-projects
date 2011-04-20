package com.gmail.gbmarkovsky.combinatory;

import java.io.FileWriter;
import java.io.IOException;

public class CheckSumCount {
	private static void calcNumbersCount() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("numbers.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int counter = 0;
		for (int i = 0; i <= 999999; i++) {
			char[] num = Integer.toString(i).toCharArray();
			int[] numbers = new int[6];
			int d = 6 - num.length;
			for (int j = numbers.length - 1; j >= 0; j--) {
				if (num.length - j > 0) {
					numbers[j+d] = Integer.parseInt(Character.toString(num[j]));
				} else {
					numbers[j] = 0;
				}
			}
			int sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4];
			int res1 = sum % 10 + sum / 10;
			int res = res1 % 10 + res1 / 10;
			int check = numbers[5];
			String s = new String("");
			for (int j = 0; j < numbers.length; j++) {
				s += Integer.toString(numbers[j]);
			}
			try {
				fw.write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (res == check) {
				counter++;
				try {
					fw.write("+\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					fw.write("-\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Результат: " + counter);
	}
	
	private static void calcAllSumCount() {
		for (int i = 1; i <= 9; i++) {
			int counter = 0;
			for (int k = 0; k <= 99999; k++) {
				char[] num = Integer.toString(k).toCharArray();
				int[] numbers = new int[5];
				int d = 5 - num.length;
				for (int j = numbers.length - 1; j >= 0; j--) {
					if (num.length - j > 0) {
						numbers[j+d] = Integer.parseInt(Character.toString(num[j]));
					} else {
						numbers[j] = 0;
					}
				}
				int sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4];
				int res1 = sum % 10 + sum / 10;
				int res = res1 % 10 + res1 / 10;
				if (res == i) {
					counter++;
					//if (i == 1)
					//System.out.println(num);
				}
			}
			System.out.println("Для " + i + " есть " + counter + " комбинаций");
		}
	}
	
	public static void main(String[] args) {
		calcAllSumCount();
		calcNumbersCount();
	}
}
