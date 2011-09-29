package com.euler.project;

import java.util.ArrayList;

public class Problem_2 {

	private static ArrayList<Integer> mFibs;

	private static void generateFib(int upperBound) {
		int first = 1, second = 2, temp;
		mFibs = new ArrayList<Integer>();
		mFibs.add(first);
		mFibs.add(second);
		while (second < upperBound) {
			temp = first;
			first = second;
			second += temp;
			mFibs.add(second);
		}
	}

	private static long findSum() {
		long sum = 0L;
		for (int i = 0; i < mFibs.size(); ++i) {
			if (mFibs.get(i) % 2 == 0) {
				sum += mFibs.get(i);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		generateFib(4000000);
		System.out.println(findSum());
	}
}
