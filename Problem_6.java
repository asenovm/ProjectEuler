package com.euler.project;

public class Problem_6 {

	private static long generateSum(int from, int to, int factor) {
		long sum = 0L;
		for (int i = from; i <= to; ++i) {
			sum += i * factor;
		}
		return sum;
	}

	public static void main(String[] args) {
		long sum = 0L;
		for (int i = 1; i < 100; ++i) {
			sum += 2 * generateSum(i+1, 100, i);
		}
		System.out.println(sum);

	}
}
