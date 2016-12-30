package org.usfirst.frc.team5546.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {	
	// ** PWM **
	
	// Drive train
	public static final int FRONT_LEFT_DRIVE_MOTOR = 4;
	public static final int FRONT_RIGHT_DRIVE_MOTOR = 5;
	public static final int REAR_LEFT_DRIVE_MOTOR = 3;
	public static final int REAR_RIGHT_DRIVE_MOTOR = 2;
	
	// Counter rotational wheels
	public static final int LEFT_COUNTER_MOTOR = 0;
	public static final int RIGHT_COUNTER_MOTOR = 1;
	
	// Winch
	public static final int WINCH_MOTOR = 6;
	
	// ** Joystick **
	
	// Drive train
	public static final int LEFT_DRIVE_AXIS = 1;
	public static final int RIGHT_DRIVE_AXIS = 1;
	
	// Counter rotational wheels
	public static final int SUCK_AXIS = 5;
	
	// Winch
	public static final int WINCH_AXIS = 1;
}
