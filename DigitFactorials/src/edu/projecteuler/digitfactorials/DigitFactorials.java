package edu.projecteuler.digitfactorials;

import java.util.LinkedList;
import java.util.List;

public class DigitFactorials {

	private static long factorial(int x) {
		long result = 1L;
		for (int i = 2; i <= x; ++i) {
			result = result * i;
		}
		return result;
	}

	private static List<Integer> getDigits(int number) {
		final List<Integer> digits = new LinkedList<>();
		while (number > 0) {
			digits.add(number % 10);
			number = number / 10;
		}
		return digits;
	}

	public static void main(String[] args) {
		long sum = 0L;
		for (int i = 3; i < 60000; ++i) {
			final List<Integer> digits = getDigits(i);
			long digitFactorial = 0L;
			for (final Integer integer : digits) {
				digitFactorial += factorial(integer);
			}
			if (digitFactorial == i) {
				sum += i;
			}
		}
		System.out.println(factorial(145));
		System.out.println(sum);
	}
}
