package edu.projecteuler.factorialsum;

import java.math.BigInteger;

public class FactorialSum {

	private static BigInteger factoriel(int n) {
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= n; ++i) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		return result;
	}

	private static long getSumOfDigits(BigInteger number) {
		long result = 0L;
		while (number.compareTo(new BigInteger("0")) > 0) {
			result += number.mod(new BigInteger("10")).longValue();
			number = number.divide(new BigInteger("10"));
		}
		return result;
	}

	public static void main(String[] args) {
		BigInteger factoriel = factoriel(100);
		System.out.println(getSumOfDigits(factoriel));
	}
}
