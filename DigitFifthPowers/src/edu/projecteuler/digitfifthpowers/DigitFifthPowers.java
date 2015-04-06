package edu.projecteuler.digitfifthpowers;

import java.util.LinkedList;
import java.util.List;

public class DigitFifthPowers {

	private static List<Integer> getDigits(int number) {
		final List<Integer> result = new LinkedList<>();
		while (number > 0) {
			result.add(number % 10);
			number = number / 10;
		}
		return result;
	}

	private static long getDigitsPowerSum(final int number, final int power) {
		final List<Integer> digits = getDigits(number);

		long result = 0L;
		for (Integer digit : digits) {
			result += Math.pow(digit, power);
		}
		return result;
	}

	public static void main(String[] args) {
		long result = 0L;
		for (int i = 2; i < 1000000; ++i) {
			if (i == getDigitsPowerSum(i, 5)) {
				result += i;
			}
		}
		System.out.println("sum is " + result);
	}
}
