package edu.fmi.projecteuler.primepermutations;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrimePermutations {

	private static boolean isPrime(final int x) {
		for (int i = 2; i < x / 2; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static List<Integer> getDigits(int x) {
		final List<Integer> result = new LinkedList<Integer>();

		if (x == 0) {
			result.add(x);
		}

		while (x > 0) {
			result.add(x % 10);
			x = x / 10;
		}

		Collections.reverse(result);
		return result;
	}

	private static Map<Integer, Integer> getDigitOccurrences(
			final Collection<Integer> digits) {
		final Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
		for (final Integer digit : digits) {
			if (result.containsKey(digit)) {
				result.put(digit, result.get(digit) + 1);
			} else {
				result.put(digit, 1);
			}
		}
		return result;
	}

	private static boolean arePermutations(final int x, final int y) {
		final List<Integer> xDigits = getDigits(x);
		final List<Integer> yDigits = getDigits(y);
		final Map<Integer, Integer> xDigitsOccurrences = getDigitOccurrences(xDigits);
		final Map<Integer, Integer> yDigitsOccurrences = getDigitOccurrences(yDigits);

		if (!xDigitsOccurrences.keySet().equals(yDigitsOccurrences.keySet())) {
			return false;
		}

		for (final Integer key : xDigitsOccurrences.keySet()) {
			if (!xDigitsOccurrences.get(key)
					.equals(yDigitsOccurrences.get(key))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		for (int i = 1001; i < 10000; i += 2) {
			for (int j = i + 2; j < 10000; j += 2) {
				for (int k = j + 2; k < 10000; k += 2) {
					if (((j - i) == (k - j)) && isPrime(i) && isPrime(j)
							&& isPrime(k) && arePermutations(i, j)
							&& arePermutations(j, k)) {
						System.out.println("solution is " + i + " " + j + " "
								+ k);
					}
				}
			}
		}
	}
}
