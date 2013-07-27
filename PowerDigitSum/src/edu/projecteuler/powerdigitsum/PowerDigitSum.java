package edu.projecteuler.powerdigitsum;

import java.math.BigInteger;

public class PowerDigitSum {

	public static long getSumOfDigits(BigInteger number) {
		long sum = 0L;
		final BigInteger step = new BigInteger("10");
		while (number.compareTo(new BigInteger("0")) > 0) {
			sum += number.mod(step).longValue();
			number = number.divide(step);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(getSumOfDigits(new BigInteger("2").pow(1000)));
	}
}
