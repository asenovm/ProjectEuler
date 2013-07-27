package edu.projecteuler.amicablenumbers;

public class AmicableNumbers {

	public static void main(String[] args) {
		final AmicableNumberGenerator generator = new AmicableNumberGenerator();
		System.out.println(generator.getAmicableNumbersSum(10000));
	}
}
