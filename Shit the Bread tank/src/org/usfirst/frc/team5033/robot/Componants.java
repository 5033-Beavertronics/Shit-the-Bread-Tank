package org.usfirst.frc.team5033.robot;
import java.util.Set;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;

public class Componants {
	
	SendableChooser chooser;


	public BooleanSupplier isAutoCheck;
	NetworkTable table;
	AnalogGyro gyro = new AnalogGyro(define.GYRO_PORT);
	Auto auto = new Auto();


	public boolean isAuto() throws AutoEndException {
		if (!isAutoCheck.getAsBoolean()) {
			throw new AutoEndException();
		}
		return isAutoCheck.getAsBoolean();
	}
	
	
	Encoder rightDriveEncoder = new Encoder(define.RIGHT_DRIVE_ENCODER_CHANNEL_A,
			define.RIGHT_DRIVE_ENCODER_CHANNEL_B, true, EncodingType.k4X);
	//combine the motors together 

	TalonSRX rightDriveF = new TalonSRX(define.RIGHT_CHANNEL_FRONT);
	TalonSRX rightDriveB = new TalonSRX(define.RIGHT_CHANNEL_BACK);
	TalonSRX leftDriveF = new TalonSRX(define.LEFT_CHANNEL_FRONT);
	TalonSRX leftDriveB = new TalonSRX(define.LEFT_CHANNEL_BACK);
	TalonSRX ropeDrive = new TalonSRX(define.ROPE_DRIVE_MOTOR);
	Spark gearDrive = new Spark(define.SPARK_DRIVE_MOTOR);
	
	
	public Componants(BooleanSupplier robotStateCheck) {
		isAutoCheck = robotStateCheck;
		table = NetworkTable.getTable("SmartDashboard");

}

	
	RobotDrive drive = new RobotDrive(leftDriveF, leftDriveB, rightDriveF, rightDriveB);

	

public void setSensors(){
	rightDriveEncoder.setDistancePerPulse(define.DISTANCE_PER_PULSE);
	gyro.reset();
    rightDriveEncoder.reset();
}


public void killMotors(){
	rightDriveF.set(0);
	rightDriveB.set(0);
	leftDriveF.set(0);
	leftDriveB.set(0);
}
}