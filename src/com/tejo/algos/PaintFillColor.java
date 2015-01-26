package com.tejo.algos;

public class PaintFillColor {

	/**
	 * Implement the “paint fill” function that one might see on many image editing pro- grams 
	 * That is, given a screen (represented by a 2-dimensional array of Colors), a point, 
	 * and a new color, fill in the surrounding area until you hit a border of that color
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public enum Color{
		RED,BLACK,WHITE,GREEN,YELLOW
	}
	
	public void paintColor(Color[][] screen,int x,int y,Color oColor,Color nColor){
		if(x < 0 || x >= screen[0].length ||
			y < 0 || y >= screen.length)
			return;
		if(screen[x][y] == oColor){
			screen[x][y] = nColor;
			paintColor(screen, x-1, y, oColor, nColor);
			paintColor(screen, x+1, y, oColor, nColor);
			paintColor(screen, x, y-1, oColor, nColor);
			paintColor(screen, x, y+1, oColor, nColor);
		}
	}

}
