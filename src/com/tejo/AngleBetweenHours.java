package com.tejo;

public class AngleBetweenHours {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String time = "03:25";
		String times[] = time.split(":");
		int hours = Integer.parseInt(times[0]);
		int minutes = Integer.parseInt(times[1]);
		
		double minutesAngle = 360 * minutes/60;
		double hoursAngle = 360 * (hours%12)/12 + 360 * minutes/60 *1/12;
		
		System.out.println(hoursAngle - minutesAngle);
	}

}
