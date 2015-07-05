package edu.projecteuler.consecutiveprimessum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConsecutivePrimesSum {

	private static List<Integer> getPrimesBelow(final int limit) {
		final boolean[] primes = new boolean[limit];
		Arrays.fill(primes, true);
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

	private static int getSumMembers(final int number,
			final List<Integer> primes) {
		int currentSum = 0;
		int start = 0;
		int iter = 0;
		while (currentSum != number && start < primes.size()
				&& primes.get(start) <= number) {
			iter = start;
			while (currentSum < number) {
				currentSum += primes.get(iter);
				++iter;
			}
			if (currentSum == number) {
				return iter - start;
			}
			++start;
		}
		return -1;
	}

	public static void main(String[] args) {
		final List<Integer> primes = getPrimesBelow(1000001);
		System.out.println("primes are " + getSumMembers(953, primes));
	}
}
