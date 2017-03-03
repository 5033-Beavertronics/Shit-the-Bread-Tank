package org.usfirst.frc.team5033.robot;

import edu.wpi.first.wpilibj.Relay;
@SuppressWarnings("unused")
public abstract class AutoMethods {
	Componants c;
	VisionData vd;

	public AutoMethods(Componants c) {
		this.c = c;
		vd = new VisionData(c);
	}




public void driving(double desiredDistance) throws AutoEndException {
	double startingAngle = c.gyro.getAngle();
	c.rightDriveEncoder.reset();
	while (c.isAuto()) {
		double currentAngle = c.gyro.getAngle();
		double deltaAngle = startingAngle - currentAngle;
		double currentDistance = c.rightDriveEncoder.getDistance();

		if (currentDistance <= desiredDistance) {
			c.leftDriveB.set(0);
			c.leftDriveF.set(0);
			c.rightDriveB.set(0);
			c.rightDriveF.set(0);
			break;
		} else {
			// Positive for left drive and negative for right drive will
			// make the robot go forward.
			c.leftDriveF.set(CalcSpeed.calcSpeedForDrivingStraight(deltaAngle, CalcSpeed.LEFT));
			c.leftDriveB.set(CalcSpeed.calcSpeedForDrivingStraight(deltaAngle, CalcSpeed.LEFT));
			c.rightDriveF.set(CalcSpeed.calcSpeedForDrivingStraight(deltaAngle, CalcSpeed.RIGHT));
			c.rightDriveB.set(CalcSpeed.calcSpeedForDrivingStraight(deltaAngle, CalcSpeed.RIGHT));
		}
	}
}
public void gyroTurning(double desiredAngle) throws AutoEndException {
	// - 90 for a desired angle is left and + 90 is right.
	double startingAngle = c.gyro.getAngle();

	while (c.isAuto()) {
		double currentAngle = c.gyro.getAngle();
		double delta = (desiredAngle - (currentAngle - startingAngle));

		if (Math.abs(delta) < 4) {
			c.leftDriveF.set(0);
			c.rightDriveB.set(0);
			c.leftDriveB.set(0);
			c.rightDriveF.set(0);
			break;
		} else {
			
			
			c.leftDriveF.set(CalcSpeed.calcSpeedForGyroscopeTurning(delta, CalcSpeed.LEFT));
			c.leftDriveB.set(CalcSpeed.calcSpeedForGyroscopeTurning(delta, CalcSpeed.LEFT));
			
			
			c.rightDriveB.set(-CalcSpeed.calcSpeedForGyroscopeTurning(delta, CalcSpeed.RIGHT));
			c.rightDriveF.set(-CalcSpeed.calcSpeedForGyroscopeTurning(delta, CalcSpeed.RIGHT));
			
			// c.leftDrive.set(calcSpeedForGyroscopeTurningLeftDrive(delta));
			// c.rightDrive.set(-calcSpeedForGyroscopeTurningRightDrive(delta));
			
			//CalcSpeed is just *'ing it by 1 or -1**
		}
	}
}

public void straight(int direction, double desireddistance) throws AutoEndException{
	double Kp = 0.1;
	while(c.isAuto()){
		c.gyro.reset();
		double angle = c.gyro.getAngle();
		double distance = c.rightDriveEncoder.getDistance();
		if(direction == 1){
		while(distance <= desireddistance){
			c.drive.drive(-.1, -angle*Kp);
		}
		c.drive.drive(0, 0);
		if(direction == -1){
		while(distance <= desireddistance){
			c.drive.drive(.1, -angle*Kp);
		}
		}
		}
		
	}
	c.killMotors();
	
	
}


public void gyroRotate(double desired,double speed) throws AutoEndException{
	while(c.isAuto()){
		c.gyro.reset();
		if(desired > 1){
			while(c.gyro.getAngle() < desired){
				c.drive.drive(speed,  speed);
			}
			c.drive.drive(0, 0);
			
		}
		else if(desired < 1){
			while(c.gyro.getAngle() < desired){
				c.drive.drive(-speed,  -speed);
			}
			c.drive.drive(0, 0);
		}
	}
	c.drive.drive(0,0);
	c.killMotors();

	
	
}






















public void gyroCentering() throws AutoEndException {
	while (c.isAuto()) {
		gyroTurning(-c.gyro.getAngle());
		break;
	}
}
public abstract void run() throws AutoEndException;
}