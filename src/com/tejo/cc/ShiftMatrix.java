package com.tejo.cc;

public class ShiftMatrix {

	/**
	 * @param args
	 */
	//Shift Matrix by 90 Degrees
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
		int[][] newMatrix = swap(matrix, 4);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("***************");
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix.length; j++) {
				System.out.print(newMatrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		swap2(newMatrix, 4);
		System.out.println("***************");
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix.length; j++) {
				System.out.print(newMatrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
	}
	
	//Without extra space and half the time of other swap
	public static void swap2(int[][] matrix,int n){
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n-1-i; j++) {
				int top = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = top;
			}
		}
	}
	public static int[][] swap(int[][] matrix, int n){
		int[][] newMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMatrix[j][n-1-i] = matrix[i][j];
			}
		}
		return newMatrix;
	}

}

