package edu.projecteuler.nonabundantsums;

import java.util.LinkedList;
import java.util.List;

public class NonAbundantSums {
	private static List<Integer> getDivisors(final int number) {
		final List<Integer> result = new LinkedList<>();
		for (int i = 1; i <= number / 2; ++i) {
			if (number % i == 0) {
				result.add(i);
			}
		}
		return result;
	}

	private static boolean isAbundant(final int number) {
		final List<Integer> divisors = getDivisors(number);
		int divisorsSum = 0;
		for (Integer divisor : divisors) {
			divisorsSum += divisor;
		}
		return divisorsSum > number;
	}

	private static boolean isAbundantSum(final int number) {
		for (int i = 1; i <= number / 2; ++i) {
			if (isAbundant(i) && isAbundant(number - i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int result = 0;
		for (int i = 0; i <= 28123; ++i) {
			if (!isAbundantSum(i)) {
				result += i;
			}
		}
		System.out.println("result is " + result);
	}
}
