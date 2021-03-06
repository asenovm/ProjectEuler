package edu.projecteuler.circularprimes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CircularPrimes {

	private static boolean isPrime(int x) {
		final int end = (int) (Math.sqrt(x) + 1);
		for (int i = 2; i < end; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static List<Integer> getDigits(int number) {
		final List<Integer> result = new LinkedList<Integer>();
		while (number > 0) {
			result.add(0, number % 10);
			number = number / 10;
		}
		return result;
	}

	private static int digitsToNumber(final int[] digits) {
		int result = 0;
		for (int i = 0; i < digits.length; ++i) {
			result += digits[i] * Math.pow(10, digits.length - i - 1);
		}
		return result;
	}

	private static List<Integer> getRotations(int number) {
		final List<Integer> result = new LinkedList<>();
		final List<Integer> digits = getDigits(number);

		int rotationCount = 0;
		final int[] copy = new int[digits.size()];
		for (int i = 0; i < digits.size(); ++i) {
			copy[i] = digits.get(i);
		}
		while (rotationCount < digits.size()) {
			int swap = copy[copy.length - 1];
			for (int i = copy.length - 1; i > 0; --i) {
				copy[i] = copy[i - 1];
			}
			copy[0] = swap;
			result.add(digitsToNumber(copy));
			++rotationCount;
		}

		return result;
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < 100; ++i) {
			if (isPrime(i)) {
				final List<Integer> rotations = getRotations(i);
				boolean isCircularPrime = true;
				for (Integer rotation : rotations) {
					if (!isPrime(rotation)) {
						isCircularPrime = false;
						break;
					}
				}
				if (isCircularPrime) {
					++count;
				}
			}
		}
		System.out.println(count);
	}
}
