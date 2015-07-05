package edu.fmi.projecteuler.distinctprimefactors;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactors {

	private static boolean isPrime(final int x) {
		for (int i = 2; i < x / 2; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static Set<Integer> getFactors(final int x) {
		final Set<Integer> factors = new HashSet<Integer>();
		int value = x;
		for (int i = 2; i < x; ++i) {
			if (value % i == 0) {
				factors.add(i);
			}

			while (value % i == 0) {
				value = value / i;
			}

		}
		return factors;
	}

	private static boolean hasNDistinctPrimeFactors(final int x, final int n) {
		final Set<Integer> factors = getFactors(x);

		if (factors.size() != n) {
			return false;
		}

		boolean result = true;
		for (Integer factor : factors) {
			result = result && isPrime(factor);
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 2; i < Integer.MAX_VALUE; ++i) {
			System.out.println("current value is " + i);
			if (hasNDistinctPrimeFactors(i, 4)
					&& hasNDistinctPrimeFactors(i + 1, 4)
					&& hasNDistinctPrimeFactors(i + 2, 4)
					&& hasNDistinctPrimeFactors(i + 3, 4)) {
				System.out.println("******************RESULT**************");
				System.out.println(i);
				System.out.println("******************RESULT**************");
				break;
			}
		}
	}
}
