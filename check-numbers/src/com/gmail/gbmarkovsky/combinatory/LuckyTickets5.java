package com.gmail.gbmarkovsky.combinatory;

public class LuckyTickets5 {
	public static void main(String[] args) {
		calc3DigitSum5();
		calcTicketCount();
	}

	private static void calc3DigitSum5() {
		int counter = 0;
		for (int i = 0; i < 999; i++) {
			char[] num = Integer.toString(i).toCharArray();
			int[] numbers = new int[3];
			int d = 3 - num.length;
			for (int j = numbers.length - 1; j >= 0; j--) {
				if (num.length - j > 0) {
					numbers[j+d] = Integer.parseInt(Character.toString(num[j]));
				} else {
					numbers[j] = 0;
				}
			}
			int sum1 = numbers[0] + numbers[1] + numbers[2];
			if (sum1 == 5) {
				counter++;
				System.out.println(Integer.toString(numbers[0]) + Integer.toString(numbers[1]) + Integer.toString(numbers[2]));
			}
		}
		System.out.println("Трехзначных чисел с суммой цифр 5: " + counter + "\n");
	}
	
	private static void calcTicketCount() {
		int counter = 0;
		for (int i = 0; i < 999999; i++) {
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
			int sum1 = numbers[0] + numbers[1] + numbers[2];
			int sum2 = numbers[3] + numbers[4] + numbers[5];
			if (sum1 == 5 && sum2 == 5) {
				counter++;
			}
		}
		System.out.println("Результат: " + counter);
	}
}
