package utils;

import custom_exception.SpeedOutOfRangeException;

// utils are always static because we need to call them w/o instantation 
public class SpeedUtils {
	//constants are in CAPITAL LETTERS
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	static {
		MIN_SPEED = 40;
		MAX_SPEED = 80;
	}
	//add static method to validate the speed
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException{
		if(speed < MIN_SPEED)
			throw new SpeedOutOfRangeException("You are driving too slow!!!!");
		if(speed > MAX_SPEED)
			throw new SpeedOutOfRangeException("You are driving to fast");
//		==>speed within the range
		System.out.println("speed within range!!!!");
		
	}
}