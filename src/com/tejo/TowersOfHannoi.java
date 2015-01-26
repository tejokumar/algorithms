package com.tejo;

public class TowersOfHannoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		doHannoi(4, 'A', 'B', 'C');
	}
	
	public static void doHannoi(int top,char src, char inter, char dest){
		if(top == 1)
			System.out.println("Disk 1 from " + src + " to "+ dest);
		else{
			doHannoi(top-1, src, dest, inter);
			System.out.println("Disk " + top +   // move bottom
                    " from " + src + " to "+ dest);
			doHannoi(top-1, inter, src, dest);
		}
			
		
	}

}
