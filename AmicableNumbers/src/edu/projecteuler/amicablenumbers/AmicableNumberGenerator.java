package edu.projecteuler.amicablenumbers;

import java.util.LinkedList;
import java.util.List;

public class AmicableNumberGenerator {

	private List<Integer> getDivisors(final int number) {
		final List<Integer> result = new LinkedList<Integer>();
		for (int i = 2; i <= Math.sqrt(number); ++i) {
			if (number % i == 0) {
				result.add(i);
			}
		}

		final List<Integer> addition = new LinkedList<Integer>();

		for (final Integer each : result) {
			addition.add(number / each);
		}
		result.add(1);
		result.addAll(addition);

		return result;
	}

	private int getDivisorsSum(final int number) {
		final List<Integer> divisors = getDivisors(number);
		int sum = 0;
		for (final Integer each : divisors) {
			sum += each;
		}
		return sum;
	}

	private boolean isAmicableNumber(final int number) {
		final int divisorsSumNumber = getDivisorsSum(number);
		final int divisorsSumDivisorsSumNumber = getDivisorsSum(divisorsSumNumber);
		return divisorsSumDivisorsSumNumber == number && divisorsSumNumber != number;
	}

	private List<Integer> getAmicableNumbers(final int upperBound) {
		final List<Integer> result = new LinkedList<Integer>();
		for (int i = 2; i < upperBound; ++i) {
			if (isAmicableNumber(i)) {
				result.add(i);
			}
		}
		return result;
	}

	public long getAmicableNumbersSum(final int upperBound) {
		final List<Integer> amicableNumbers = getAmicableNumbers(upperBound);
		long sum = 0;
		for (final Integer each : amicableNumbers) {
			sum += each;
		}
		return sum;
	}
}
