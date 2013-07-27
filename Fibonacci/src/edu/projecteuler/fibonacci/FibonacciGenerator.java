package edu.projecteuler.fibonacci;

import java.math.BigInteger;

public class FibonacciGenerator {

	public BigInteger getFibonnaciNumber(int position) {
		BigInteger currentFirstRowFirstColumn = new BigInteger("1");
		BigInteger currentFirstRowSecondColumn = new BigInteger("1");
		BigInteger currentSecondRowFirstColumn = new BigInteger("1");
		BigInteger currentSecondRowSecondColumn = new BigInteger("0");

		for (int i = 0; i < position - 2; ++i) {
			final BigInteger newFirstRowFirstColumn = currentFirstRowFirstColumn
					.add(currentFirstRowSecondColumn);
			final BigInteger newFirstRowSecondColumn = currentFirstRowFirstColumn;
			final BigInteger newSecondRowFirstColumn = currentSecondRowFirstColumn
					.add(currentSecondRowSecondColumn);
			final BigInteger newSecondRowSecondColumn = currentSecondRowFirstColumn;

			currentFirstRowFirstColumn = newFirstRowFirstColumn;
			currentFirstRowSecondColumn = newFirstRowSecondColumn;
			currentSecondRowFirstColumn = newSecondRowFirstColumn;
			currentSecondRowSecondColumn = newSecondRowSecondColumn;
		}
		return currentFirstRowFirstColumn;
	}
}
