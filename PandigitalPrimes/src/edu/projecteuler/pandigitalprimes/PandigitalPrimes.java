package edu.projecteuler.pandigitalprimes;

public class PandigitalPrimes {

	private static boolean isPrime(int x) {
		int end = (int) (Math.sqrt(x) + 1);
		for (int i = 2; i <= end; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int getLength(int number) {
		int length = 0;
		while (number > 0) {
			++length;
			number = number / 10;
		}
		return length;
	}

	private static boolean containsDigit(int number, int digit) {
		while (number > 0) {
			if (number % 10 == digit) {
				return true;
			}
			number = number / 10;
		}
		return false;
	}

	private static boolean isPandigital(int number) {
		final int digitLength = getLength(number);
		for (int i = 1; i <= digitLength; ++i) {
			if (!containsDigit(number, i)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int largest = Integer.MIN_VALUE;
		for (int i = 2; i < 999999999; ++i) {
			if (isPandigital(i) && isPrime(i) && largest < i) {
				largest = i;
			}
		}
		System.out.println(largest);
	}
}
