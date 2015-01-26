package com.tejo.cc;

public class SetRowsAndColumnsToZero {

	/**
	 * @param args
	 */
	//Set Rows and columns to zero of there is a zero in matrix
	public static void main(String[] args) {
		int[][] matrix = {{0,2,3,4},{5,6,7,8},{9,2,1,2},{3,4,5,6}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("***************");
		setZeros(matrix, 4, 4);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static void setZeros(int[][] matrix,int rows,int columns){
		int rowChecker =0;
		int columnChecker =0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int val = matrix[i][j];
				if(matrix[i][j]==0 && (rowChecker & (1<<i)) ==0
						&& (columnChecker & (1<<j)) ==0)//Bitwise is used to check if the row or column is not processed
				{
					rowChecker = rowChecker | (1<<i);
					columnChecker = columnChecker | (1<<j);
					
					for (int k = 0; k < columns; k++) {
						matrix[i][k]=0;
					}
					for (int k = 0; k < rows; k++) {
						matrix[k][j]=0;
					}
				}	
			}
		}
	}
}
