package edu.projecteuler.triangle;

public class DivisorCounter {

	public int getNumberOfDivisors(final int number) {
		int result = 0;
		for (int i = 1; i <= Math.sqrt(number); ++i) {
			if (number % i == 0) {
				++result;
			}
		}
		// result holds the number of prime divisors. Total number of divisors
		// is prime divisors + the number
		// of divisors in the form <number>/<prime_divisor>
		return 2 * result;
	}
}
