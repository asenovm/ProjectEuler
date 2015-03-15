package edu.projecteuler.goldbachsotherconjecture;

public class Goldbach {

	public static boolean isPrime(final int number) {
		for (int i = 2; i < number; ++i) {
			if (number % i == 0) {
				return false;
			}
		}
		return number != 1;
	}

	public static boolean isSquare(final int number) {
		final int squared = (int) Math.sqrt(number);
		return squared * squared == number;
	}

	public static boolean isGoldbachNumber(final int number) {
		for (int i = 2; i < number - 1; ++i) {
			final int remainder = number - i;
			if (isPrime(i) && (remainder % 2 == 0) && isSquare(remainder / 2)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		for (int i = 3; i < Integer.MAX_VALUE; i += 2) {
			if (!isPrime(i) && !isGoldbachNumber(i)) {
				System.out.println("smallest non-goldbach number is " + i);
				return;
			}
		}
	}
}
