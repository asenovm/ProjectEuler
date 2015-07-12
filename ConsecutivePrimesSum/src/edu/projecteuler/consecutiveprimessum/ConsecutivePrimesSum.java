package edu.projecteuler.consecutiveprimessum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConsecutivePrimesSum {

	private static List<Integer> getPrimesBelow(final int limit) {
		final boolean[] primes = new boolean[limit];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		int current = 2;
		while (current < limit) {
			int iter = current;
			while (iter + current < limit) {
				iter += current;
				primes[iter] = false;
			}
			++current;
		}

		final List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < primes.length; ++i) {
			if (primes[i]) {
				result.add(i);
			}
		}

		return result;
	}

	private static int getMaxPrimeSum(final List<Integer> primes) {
		int maxLength = 0;
		int maxNumber = 0;
		for (int i = 0; i < primes.size(); ++i) {
			final int currentPrime = primes.get(i);

			for (int j = 0; j < i; ++j) {
				int currentSum = 0;
				int currentLength = 0;
				for (int k = j; k < i; ++k) {
					currentSum += primes.get(k);
					++currentLength;
					if (currentSum > currentPrime) {
						break;
					} else if ((currentSum == currentPrime) && (currentLength > maxLength)) {
						maxLength = currentLength;
						maxNumber = currentPrime;
					}
				}
			}
		}
		return maxNumber;
	}

	public static void main(String[] args) {
		final List<Integer> primes = getPrimesBelow(1000000);
		System.out.println(getMaxPrimeSum(primes));
	}
}
