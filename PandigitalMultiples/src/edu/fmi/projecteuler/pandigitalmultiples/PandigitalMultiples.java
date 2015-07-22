package edu.fmi.projecteuler.pandigitalmultiples;

public class PandigitalMultiples {

	private static boolean isPandigital(int number) {
		final boolean[] flags = new boolean[10];
		while (number > 0) {
			flags[number % 10] = true;
			number = number / 10;
		}

		boolean result = true;

		for (int i = 1; i < flags.length; ++i) {
			result = result && flags[i];
		}

		return result;
	}

	public static void main(String[] args) {
		long maxValue = 0;
		for (int i = 2; i < Math.pow(10, 5); ++i) {
			StringBuilder builder = new StringBuilder();
			for (int j = 1; j < Math.pow(10, 4); ++j) {
				builder.append(i * j);
				if (builder.length() == 9) {
					int value = Integer.valueOf(builder.toString(), 10);
					if ((value > maxValue) && isPandigital(value)) {
						maxValue = value;
						builder = new StringBuilder();
					}
				}
			}
		}
		System.out.println("max value is " + maxValue);
	}
}
