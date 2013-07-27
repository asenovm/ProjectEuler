package edu.projecteuler.fibonacci;

import java.math.BigInteger;

public class FibonacciDigits {
	public static void main(String[] args) {
		final FibonacciGenerator generator = new FibonacciGenerator();
		BigInteger currentFibonacci = new BigInteger("1");
		int current = 1;
		while (currentFibonacci.toString().length() < 1000) {
			currentFibonacci = generator.getFibonnaciNumber(++current);
		}
		
		System.out.println(current);
		System.out.println(currentFibonacci);
	}
}
