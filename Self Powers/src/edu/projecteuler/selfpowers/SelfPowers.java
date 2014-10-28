package edu.projecteuler.selfpowers;

public class SelfPowers {

	private static long getTenDigitSelfPower(int x) {
		long result = 1;
		for(int i = 0; i < x; ++i){
			result = result * x;
			result = result % 10000000000L;
		}
		return result;
	}

	public static void main(String[] args) {
		long result = 0L;
		for(int i = 1; i <= 1000; ++i){
			result += getTenDigitSelfPower(i);
			result = result % 10000000000L;
		}
		System.out.println(result);
	}
}
