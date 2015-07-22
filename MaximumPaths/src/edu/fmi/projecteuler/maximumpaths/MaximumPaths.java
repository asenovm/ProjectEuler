package edu.fmi.projecteuler.maximumpaths;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MaximumPaths {

	private static class Neighbour {
		private int i;

		private int j;

		public Neighbour(final int i, final int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static Collection<Neighbour> getNeighbours(final int[][] matrix, final int i, final int j) {
		final List<Neighbour> result = new LinkedList<>();
		for (int start = i - 1; start <= i + 1; ++start) {
			for (int startY = j - 1; startY <= j + 1; ++startY) {
				if (((start == i) && (startY == j)) || (start < 0) || (startY < 0) || (start >= matrix.length)
						|| (startY >= matrix[0].length)) {
					continue;
				}
				if (matrix[start][startY] > 0) {
					result.add(new Neighbour(start, startY));
				}
			}
		}
		return result;
	}

	private static void dfs(final int[][] matrix, final boolean[][] checked, final int i, final int j) {
		if (checked[i][j]) {
			return;
		}

		checked[i][j] = true;

		for (Neighbour neighbour : getNeighbours(matrix, i, i)) {
			dfs(matrix, checked, neighbour.i, neighbour.j);
		}
	}

	public static void main(String[] args) {
		final int[][] matrix = new int[][] { { 3, 0, 0, 0 }, { 7, 4, 0, 0 }, { 2, 4, 6, 0 }, { 8, 5, 9, 3 } };
		final boolean[][] checked = new boolean[4][4];
		dfs(matrix, checked, 0, 0);
		System.out.println(Arrays.deepToString(checked));
	}
}
