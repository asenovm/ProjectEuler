package edu.fmi.projecteuler.champernowne;

public class ChampernownesConstant {
	private static String getChampernownesConstant(int fractionNumbers) {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < fractionNumbers; ++i) {
			builder.append(Integer.toString(i));
			if (builder.length() > fractionNumbers) {
				break;
			}
		}
		return builder.toString();
	}

	private static int getDigitAtPosition(final String constant, final int position) {
		return Integer.parseInt(Character.toString(constant.charAt(position)));
	}

	public static void main(String[] args) {
		final String constant = getChampernownesConstant(1000000);
		final int d1 = getDigitAtPosition(constant, 1);
		final int d10 = getDigitAtPosition(constant, 10);
		final int d100 = getDigitAtPosition(constant, 100);
		final int d1000 = getDigitAtPosition(constant, 1000);
		final int d10000 = getDigitAtPosition(constant, 10000);
		final int d100000 = getDigitAtPosition(constant, 100000);
		final int d1000000 = getDigitAtPosition(constant, 1000000);
		System.out.println("result is " + d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000);
	}
}
