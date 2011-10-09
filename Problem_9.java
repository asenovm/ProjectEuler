package com.euler.project;

import java.util.ArrayList;

public class Problem_9 {

	private static ArrayList<Triplet> mTriplets;

	private static class Triplet {

		private final int mFirst;
		private final int mSecond;
		private final int mThird;

		public Triplet(int first, int second, int third) {
			mFirst = first;
			mSecond = second;
			mThird = third;
		}

		@Override
		public String toString() {
			StringBuilder stb = new StringBuilder();
			stb.append(getFirst());
			stb.append(" ");
			stb.append(getSecond());
			stb.append(" ");
			stb.append(getThird());
			return stb.toString();
		}

		public int getFirst() {
			return mFirst;
		}

		public int getSecond() {
			return mSecond;
		}

		public int getThird() {
			return mThird;
		}
	}

	private static void generateTriplets(int sumLessThan) {
		for (int c = 1; c < sumLessThan; ++c) {
			for (int b = 1; b < c; ++b) {
				for (int a = 1; a < b; ++a) {
					if (a * a + b * b == c * c) {
						mTriplets.add(new Triplet(a, b, c));
					}
				}
			}
		}
	}

	private static Triplet getTripletWithFixedSum(int sum) {
		for (Triplet triplet : mTriplets) {
			if (triplet.getFirst() + triplet.getSecond() + triplet.getThird() == sum) {
				return triplet;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		mTriplets = new ArrayList<Triplet>();
		generateTriplets(1000);
		final Triplet resultTriplet = getTripletWithFixedSum(1000);
		if (resultTriplet == null) {
			System.out.println("bad!");
			return ;
		}
		System.out.println(resultTriplet.toString());
		System.out.println(resultTriplet.getFirst() * resultTriplet.getSecond() * resultTriplet.getThird());
	}
}
