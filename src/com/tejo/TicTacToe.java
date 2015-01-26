package com.tejo;

public class TicTacToe {
	final static char A[][] = new char[][]{
			{'o','x','o'},
			{' ','x','o'},
			{' ','x',' '}
		};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getWinningChar());

	}

	public static char getWinningChar(){
		for (int i = 0; i < 3; i++) {
			if(A[i][0] == A[i][1] && A[i][1] == A[i][2]) // Horizontal
				return A[i][0];
			if(A[0][i] == A[1][i] && A[1][i] == A[2][i]) // Vertical
				return A[0][i];
			if(i==0 && A[i][i]==A[i+1][i+1] && A[i][i]==A[i+2][i+2]) //Diagonal from top left
				return A[i][i];
			if(i==0 && A[i+2][i]==A[i+1][i+1] && A[i+1][i+1]==A[i][i+2]) //Diagonal from top right
				return A[i+2][i];
		}
		
		return 'N';
		
	}
}
