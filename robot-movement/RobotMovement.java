package com.jaiswalakshay.runner;

public class RobotMovement {
	private static int countNumberOfPath(int inputGrid[][], int row, int col) {
		if (row < 0 || row > 3 || col < 0 || col > 3) {
			return 0;
		}

		if (inputGrid[row][col]!=0) {
			return 0;
		}

		if (row == 3 && col == 3) {
			return 1;
		}

		inputGrid[row][col] = 1;

		int numbeOfPaths = 0;
	
		numbeOfPaths += countNumberOfPath(inputGrid, row - 1, col);
		numbeOfPaths += countNumberOfPath(inputGrid, row, col - 1);
		numbeOfPaths += countNumberOfPath(inputGrid, row, col + 1);
		numbeOfPaths += countNumberOfPath(inputGrid, row + 1, col);

		inputGrid[row][col] = 0;

		return numbeOfPaths;
	}

	public static void main(String[] args) {
		int initialValue[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println("Total number of paths :" + countNumberOfPath(initialValue, 0, 0));
	}

}
