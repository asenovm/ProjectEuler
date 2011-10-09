package com.euler.project;

public class Problem_7 {

	private static int[] mPrimes;

	private final static int UPPER_BOUND = 1000001;

	private static void eratostenSieve() {
		for (int i = 2; i < UPPER_BOUND; ++i) {
			for (int j = 2 * i; j < UPPER_BOUND; j += i) {
				mPrimes[j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		mPrimes = new int[UPPER_BOUND];
		for (int i = 0; i < UPPER_BOUND; ++i) {
			mPrimes[i] = i;
		}
		eratostenSieve();
		int numberOfPrimes = 0;
		for (int i = 2; i < mPrimes.length; ++i) {
			if (mPrimes[i] != 0) {
				++numberOfPrimes;
			}
			if (numberOfPrimes == 10001) {
				System.out.println(mPrimes[i]);
				return ;
			}
		}
	}

}
