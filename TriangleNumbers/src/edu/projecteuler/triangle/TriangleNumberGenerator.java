package edu.projecteuler.triangle;

public class TriangleNumberGenerator {

	public int getTriangleNumber(final int position) {
		return position * (position + 1) / 2;
	}
}
