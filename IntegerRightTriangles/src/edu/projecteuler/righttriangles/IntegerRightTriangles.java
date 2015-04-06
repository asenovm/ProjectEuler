package edu.projecteuler.righttriangles;

public class IntegerRightTriangles {

	/**
	 * {@value}
	 */
	private static final int PERIMETER_MAX = 1000;

	public static boolean isPythagorenTriple(final int a, final int b,
			final int c) {
		return a * a + b * b == c * c;
	}

	public static void main(String[] args) {
		int solutionsCount = 0;
		int maxSolutionsCount = -1;
		int optimalPerimeter = -1;

		for (int perimeter = 3; perimeter <= PERIMETER_MAX; ++perimeter) {
			for (int i = 1; i < perimeter - 1; ++i) {
				for (int j = i; j <= perimeter - i; ++j) {
					for (int k = j; k <= perimeter - i - j; ++k) {
						if ((i + j + k == perimeter)
								&& isPythagorenTriple(i, j, k)) {
							++solutionsCount;
						}
					}
				}
			}
			if (maxSolutionsCount < solutionsCount) {
				maxSolutionsCount = solutionsCount;
				optimalPerimeter = perimeter;
			}
			solutionsCount = 0;
		}

		System.out.println("solutions count is " + maxSolutionsCount + " "
				+ optimalPerimeter);
	}
}
