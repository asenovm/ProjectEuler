package com.euler.project;

import java.util.ArrayList;

public class Problem_3 {

	private static ArrayList<Long> mFactors;

	private static boolean isPrime(long number) {
		final long squaredNumber = (long) Math.sqrt(number);
		for (long i = 2; i <= squaredNumber; ++i) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static long getLargestPrimeFactor(long number) {
		mFactors = new ArrayList<Long>();
		final long squareNumber = (long) Math.sqrt(number);
		for (long i = 2; i <= squareNumber; ++i) {
			if (number % i == 0) {
				mFactors.add(i);
			}
		}
		for (int i = mFactors.size() - 1; i >= 0; --i) {
			if (isPrime(mFactors.get(i))) {
				return mFactors.get(i);
			}
		}
		return 2;
	}

	public static void main(String[] args) {
		System.out.println(getLargestPrimeFactor(600851475143L));
	}
}
