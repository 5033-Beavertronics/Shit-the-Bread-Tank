package org.usfirst.frc.team5033.robot;

public class define {


	/*
	 * public static final int is for declaring up variable
	 */
	public static final double ENCODER_GEAR_RATIO = 1;
	public static final double PULSE_PER_REVOLUTION = 360;
	public static final double GEAR_RATIO = 1 / 1.667;
	public static final double FUDGE_FACTOR = 1.7;
	public static final int WHEEL_DIAMETER = 4;
	public static final double DISTANCE_PER_PULSE = Math.PI * WHEEL_DIAMETER / PULSE_PER_REVOLUTION / ENCODER_GEAR_RATIO
			/ GEAR_RATIO * FUDGE_FACTOR;
	
	
	public static final int RIGHT_DRIVE_ENCODER_CHANNEL_A = 1;
	public static final int RIGHT_DRIVE_ENCODER_CHANNEL_B = 2;
	
	
	public static final int ROPE_DRIVE_MOTOR = 4;
	
	public static final int SPARK_DRIVE_MOTOR = 5;
	
    public static final int GYRO_PORT = 1;
	public static final int LEFT_CHANNEL_FRONT = 0;
	public static final int LEFT_CHANNEL_BACK = 1;
	public static final int RIGHT_CHANNEL_FRONT = 2;
	public static final int RIGHT_CHANNEL_BACK = 3;
	public static final int JOYSTICK_PORT = 0;
	public static final double MOTOR_FULL_SPEED_FORWARD = 0.5;
	public static final double MOTOR_FULL_SPEED_REVERSE = -0.5;
	public static final double MOTOR_OFF = 0.0;
	public static final double THROTTLE = 0.0;
	public enum AutonomousRoutines {
		TEST_AUTO,
		NUMBER_2,
		GEAR_AUTO,
	}
}
