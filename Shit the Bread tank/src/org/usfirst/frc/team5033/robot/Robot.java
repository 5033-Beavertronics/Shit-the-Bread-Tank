package org.usfirst.frc.team5033.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	Joystick Stick = new Joystick(0); 
	boolean buttonGet = Stick.getRawButton(2);
	double speedset = 0.3;
	Talon speedFL = new Talon(0);
	Talon speedBL = new Talon(1);
	Talon speedFR = new Talon(2);
	Talon speedBR = new Talon(3);
	RobotDrive myRobot = new RobotDrive(speedFL, speedBL, speedFR, speedBR);  // class that handles basic drive		


	public Robot() {
		myRobot.setExpiration(0.1);
		speedFL.set(speedset);
		speedBL.set(speedset);
		speedFR.set(speedset);
		speedBR.set(speedset);
	}

	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			if(buttonGet == false){
				myRobot.arcadeDrive(Stick);
				Timer.delay(0.005);
				
			}
			else{
				speedset = speedset * -1;
			}
			
		}
	}
}
