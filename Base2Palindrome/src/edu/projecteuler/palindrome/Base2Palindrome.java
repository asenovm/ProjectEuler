package edu.projecteuler.palindrome;

public class Base2Palindrome {
	private static boolean isPalindrome(final String string) {
		for (int i = 0; i < string.length() / 2; ++i) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long sum = 0L;
		for (int i = 1; i < 1000000; ++i) {
			final String binaryString = Integer.toBinaryString(i);
			final String decimalString = Integer.toString(i);
			if (!binaryString.startsWith("0") && isPalindrome(binaryString)
					&& isPalindrome(decimalString)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
