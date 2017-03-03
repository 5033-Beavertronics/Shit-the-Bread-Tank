package org.usfirst.frc.team5033.robot;
import edu.wpi.first.wpilibj.Joystick;

public class Controls{
	Joystick joy = new Joystick(define.JOYSTICK_PORT);
	public Controls(){
		
		
	}
	public double joystickX() {
		return joy.getX();
	}

	public double joystickY() {
		return joy.getY();
	}
	public boolean joystickTrigger(){
		return joy.getRawButton(1);
	}
	public double throttle() {
		return joy.getThrottle();
			
	}
	public boolean rope(){
		return joy.getRawButton(2);
	}
	public boolean gearForward(){
		return joy.getRawButton(3);
	}
	public boolean gearBackwards(){
		return joy.getRawButton(4);
	}
	
}