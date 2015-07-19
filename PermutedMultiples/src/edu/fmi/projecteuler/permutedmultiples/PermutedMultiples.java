package edu.fmi.projecteuler.permutedmultiples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutedMultiples {

	private static Map<Integer, Integer> getDigits(int number) {
		final Map<Integer, Integer> result = new HashMap<>();
		while (number > 0) {
			final int currentDigit = number % 10;
			number = number / 10;
			if (result.containsKey(currentDigit)) {
				result.put(currentDigit, result.get(currentDigit) + 1);
			} else {
				result.put(currentDigit, 1);
			}
		}
		return result;
	}

	private static boolean containSameDigits(final int first, final int other) {
		final Map<Integer, Integer> firstDigits = getDigits(first);
		final Map<Integer, Integer> otherDigits = getDigits(other);
		return firstDigits.equals(otherDigits);
	}

	public static void main(String[] args) {
		for (int i = 1; i < Integer.MAX_VALUE / 6; ++i) {
			boolean sameDigits = true;
			for (int mult = 2; mult < 7; ++mult) {
				if (!containSameDigits(i, mult * i)) {
					sameDigits = false;
					break;
				}
			}
			if (sameDigits) {
				System.out.println("result is " + i);
				break;
			}
		}
	}
}
