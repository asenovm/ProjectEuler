package edu.projecteuler.triangle;

public class TriangleNumber {
	public static void main(String[] args) {
		final TriangleNumberGenerator generator = new TriangleNumberGenerator();
		final DivisorCounter counter = new DivisorCounter();

		int divisorCount = 0;
		int iteration = 1;
		int currentTriangleNumber = 0;

		while (divisorCount < 500) {
			currentTriangleNumber = generator.getTriangleNumber(iteration);
			divisorCount = counter.getNumberOfDivisors(currentTriangleNumber);
			++iteration;
		}
		
		System.out.println(currentTriangleNumber);
		System.out.println(divisorCount);
	}
}
