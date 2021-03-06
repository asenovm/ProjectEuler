package edu.projecteuler.truncatableprimes;

import java.util.LinkedList;
import java.util.List;

public class TruncatablePrimes {

	private static List<Integer> getDigits(int number) {
		final List<Integer> result = new LinkedList<>();
		while (number > 0) {
			result.add(0, number % 10);
			number = number / 10;
		}
		return result;
	}

	private static int digitsToNumber(List<Integer> digits) {
		int result = 0;
		for (int i = 0; i < digits.size(); ++i) {
			result += digits.get(i) * Math.pow(10, digits.size() - i - 1);
		}
		return result;
	}

	private static int rightShift(int number) {
		final List<Integer> digits = getDigits(number);
		digits.remove(0);
		return digitsToNumber(digits);
	}

	private static int leftShift(int number) {
		final List<Integer> digits = getDigits(number);
		digits.remove(digits.size() - 1);
		return digitsToNumber(digits);
	}

	private static boolean isPrime(int x) {
		int end = (int) (Math.sqrt(x) + 1);
		for (int i = 2; i < end; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return x >= 2;
	}

	public static void main(String[] args) {
		int counter = 0;
		int start = 22;
		long sum = 0L;

		while (counter < 11) {
			int currentLeft = start;
			int currentRight = start;

			while (isPrime(currentLeft) && currentLeft > 0) {
				currentLeft = leftShift(currentLeft);
			}

			while (isPrime(currentRight) && currentRight > 0) {
				currentRight = rightShift(currentRight);
			}

			if (currentLeft == 0 && currentRight == 0) {
				sum += start;
				++counter;
			}

			++start;
		}
		System.out.println(sum);
	}
}
