package com.gmail.gbmarkovsky.combinatory;

public class CheckSumCount {
	private static void calcNumbersCount() {
		int counter = 0;
		for (int i = 100000; i < 999999; i++) {
			char[] num = Integer.toString(i).toCharArray();
			int[] numbers = new int[num.length];
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = Integer.parseInt(Character.toString(num[j]));
			}
			int sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4];
			int res1 = sum % 10 + sum / 10;
			int res = res1 % 10 + res1 / 10;
			int check = numbers[5];
			if (res == check) {
				counter++;
			}
		}
		System.out.println("Результат: " + counter);
	}
	
	private static void calcAllSumCount() {
		for (int i = 1; i <= 9; i++) {
			int counter = 0;
			for (int k = 10000; k < 99999; k++) {
				char[] num = Integer.toString(k).toCharArray();
				int[] numbers = new int[num.length];
				for (int j = 0; j < numbers.length; j++) {
					numbers[j] = Integer.parseInt(Character.toString(num[j]));
				}
				int sum = numbers[0] + numbers[1] + numbers[2] + numbers[3] + numbers[4];
				int res1 = sum % 10 + sum / 10;
				int res = res1 % 10 + res1 / 10;
				if (res == i) {
					counter++;
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
