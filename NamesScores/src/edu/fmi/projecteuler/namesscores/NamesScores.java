package edu.fmi.projecteuler.namesscores;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class NamesScores {

	private static int getValueForCharacter(final char character) {
		return Character.getNumericValue(character) - 9;
	}

	private static int getValueForString(final String str) {
		final char[] chars = str.toCharArray();
		int result = 0;
		for (int i = 0; i < chars.length; ++i) {
			result += getValueForCharacter(chars[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			final Scanner scanner = new Scanner(new File(
					"assets/p022_names.txt"));
			final String contents = scanner.next();
			final String[] names = contents.replaceAll("\"", "").split(",");

			final String[] sortedNames = Arrays.copyOf(names, names.length);
			Arrays.sort(sortedNames);

			long result = 0L;
			for (final String currentName : names) {
				final int nameValue = getValueForString(currentName);
				result += nameValue
						* (Arrays.binarySearch(sortedNames, currentName) + 1);
			}
			System.out.println("result is ");
			System.out.println(result);
		} catch (FileNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}
}
