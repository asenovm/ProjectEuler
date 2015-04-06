package edu.projecteuler.distinctpowers;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class DistinctPowers {
	private static Collection<BigInteger> getDistinctPowers(final int from,
			final int to) {
		final Set<BigInteger> result = new TreeSet<>();
		for (int i = from; i <= to; ++i) {
			for (int j = from; j <= to; ++j) {
				final BigInteger current = new BigInteger(Integer.toString(i));
				result.add(current.pow(j));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		final Collection<BigInteger> distinctPowers = getDistinctPowers(2, 100);
		System.out.println("items are " + distinctPowers.size());
	}
}
