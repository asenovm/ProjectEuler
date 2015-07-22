package edu.fmi.projecteuler.reciprocalcycles;

import java.util.LinkedList;

public class ReciprocalCycles {

	private static int getCycleLength(int nom, int denom) {
		final LinkedList<Integer> divisors = new LinkedList<>();
		final LinkedList<Integer> diffs = new LinkedList<>();
		while (nom % denom != 0) {
			while (nom < denom) {
				nom *= 10;
			}

			int diff = nom - (nom / denom) * denom;
			if (diffs.contains(diff)) {
				return diffs.subList(diffs.indexOf(diff), diffs.size()).size();
			}

			divisors.add(nom / denom);
			nom = diff;
			diffs.add(diff);
		}
		return 0;
	}

	public static void main(String[] args) {
		int maxCycleLength = 0;
		int maxCycleValue = 0;
		for (int i = 1; i < 1000; ++i) {
			int cycleLength = getCycleLength(1, i);
			if (cycleLength > maxCycleLength) {
				maxCycleLength = cycleLength;
				maxCycleValue = i;
			}
		}
		System.out.println(maxCycleValue);
		System.out.println(maxCycleLength);
	}
}
