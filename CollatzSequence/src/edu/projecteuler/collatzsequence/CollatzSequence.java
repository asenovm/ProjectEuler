package edu.projecteuler.collatzsequence;

public class CollatzSequence {

	private static int computeChainLength(int start) {
		long current = start;
		int length = 1;
		while (current > 1) {
			if (current % 2 == 0) {
				current = current / 2;
			} else {
				current = 3 * current + 1;
			}
			++length;
		}
		return length;
	}

	public static void main(String[] args) {
		int maxLen = -1;
		int maxStart = -1;
		for (int i = 2; i < 1000000; ++i) {
			final int currentLen = computeChainLength(i);
			if (currentLen >= maxLen) {
				maxLen = currentLen;
				maxStart = i;
			}
		}
		System.out.println(maxLen);
		System.out.println(maxStart);
	}
}
