package com.euler.project;

import java.util.ArrayList;
import java.util.Collections;

public class Problem_4 {

	private static ArrayList<Integer> mDigits;
	
	private static ArrayList<Integer> mPalindromes;

	public static boolean isPalindrom(int number) {
		while (number > 0) {
			mDigits.add(number % 10);
			number /= 10;
		}
		for (int i = 0; i < mDigits.size() / 2; ++i) {
			if (mDigits.get(i) != mDigits.get(mDigits.size() - i - 1)) {
				mDigits.clear();
				return false;
			}
		}
		mDigits.clear();
		return true;

	}

	public static int getLargestPalindrom() {
		mDigits = new ArrayList<Integer>();
		mPalindromes = new ArrayList<Integer>();
		for (int i = 999; i >= 100; --i)
			for (int j = 999; j >= 100; --j) {
				if (isPalindrom(i * j)) {
					mPalindromes.add(i*j);
				}
			}
		Collections.sort(mPalindromes);
		return mPalindromes.get(mPalindromes.size()-1);
	}

	public static void main(String[] args) {
		System.out.println(getLargestPalindrom());
	}

}
