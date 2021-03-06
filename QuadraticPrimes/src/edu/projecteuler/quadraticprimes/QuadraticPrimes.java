package edu.projecteuler.quadraticprimes;

public class QuadraticPrimes {

	private static boolean isPrime(int x) {
		int end = (int) (Math.sqrt(x) + 1);
		for (int i = 2; i < end; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int maxN = -1;
		int maxA = 0;
		int maxB = 0;
		for (int a = -999; a <= 999; ++a) {
			for (int b = -999; b <= 999; ++b) {
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b))) {
					++n;
				}
				if (n > maxN) {
					maxN = n;
					maxA = a;
					maxB = b;
				}
			}
		}
		System.out
				.println(maxN + " " + maxA + " " + maxB + " " + (maxA * maxB));
	}
}
