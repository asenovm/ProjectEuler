package com.euler.project;
public class Problem_10 {

	private static int UPPER_BOUND = 2000000;

	private static int[] mPrimes;

	private static void eratostenSieve() {
		for (int i = 2; i < mPrimes.length; ++i) {
			for (int j = 2 * i; j < mPrimes.length; j += i) {
				mPrimes[j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		mPrimes = new int[UPPER_BOUND];
		long primesSum = 0L;
		for (int i = 0; i < UPPER_BOUND; ++i) {
			mPrimes[i] = i;
		}
		eratostenSieve();
		for (int i = 2; i < mPrimes.length; ++i) {
				primesSum += mPrimes[i];
		}
		System.out.println(primesSum);
	}
}
