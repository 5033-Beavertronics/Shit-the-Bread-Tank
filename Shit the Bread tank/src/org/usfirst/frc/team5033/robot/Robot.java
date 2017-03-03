package org.usfirst.frc.team5033.robot;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



@SuppressWarnings("unused")
public class Robot extends IterativeRobot {
	Componants c = new Componants(() -> isEnabled() && isAutonomous());
	Controls controls = new Controls();
	



  // class that handles basic drive		


	public void robotInit() {
		c.chooser = new SendableChooser();
		c.chooser.addDefault("TEST_AUTO (DEFAULT)", define.AutonomousRoutines.TEST_AUTO);
		c.chooser.addObject("NUMBER 2", define.AutonomousRoutines.NUMBER_2);
		SmartDashboard.putData("AUTONOMOUS MODES", c.chooser);
		
		CameraServer.getInstance().startAutomaticCapture("pleaseffs", 0);
		
		//c.chooser = new SendableChooser();
		//c.chooser.addDefault("TEST_AUTO (DEFAULT)", define.AutonomousRoutines.TEST_AUTO);
		//c.chooser.addObject("NUMBER 2", define.AutonomousRoutines.NUMBER_2);
		//SmartDashboard.putData("AUTONOMOUS MODES", c.chooser);
		c.drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
	    c.drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		}
	public void autonomousInit(){ //Initialize for autonomous
		SmartDashboard.putNumber("Gyro angle", c.gyro.getAngle());
		//c.resetAll();
		c.setSensors();
		c.killMotors();
		//c.chooser.addDefault("TEST_AUTO (DEFAULT)", define.AutonomousRoutines.TEST_AUTO);
		//c.chooser.addObject("NUMBER 2", define.AutonomousRoutines.NUMBER_2);
		//SmartDashboard.putData("AUTONOMOUS MODES", c.chooser);

		try {
			c.auto.run(c.auto.routines, c);
		} catch (AutoEndException se) {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void autonomousPeriodic(){
		SmartDashboard.putNumber("Gyro angle", c.gyro.getAngle());
		SmartDashboard.putNumber("Distance amount", c.rightDriveEncoder.getDistance());
	}
	
	public void teleopInit(){
		c.drive.stopMotor();
		c.setSensors();
		c.rightDriveEncoder.reset();
		c.killMotors();
		
		//Initialize for teleop
		
	}
	

	public void teleopPeriodic() { 
		SmartDashboard.putNumber("Gyro angle", c.gyro.getAngle());
		SmartDashboard.putNumber("Distance amount", c.rightDriveEncoder.getDistance());

		try{
			if(controls.joystickTrigger())
			{
				c.drive.arcadeDrive(controls.joystickY(), -controls.joystickX());
			}
			else
			{
				c.drive.arcadeDrive(-controls.joystickY(), -controls.joystickX());				
			}
			if(controls.rope())
			{
				c.ropeDrive.set(1);
			}
			else
			{
				c.ropeDrive.set(0);
			}
			if(controls.gearForward()){
				c.gearDrive.set(0.3);
			}
			else if(controls.gearBackwards() != true){
				c.gearDrive.set(0);
			}
			if(controls.gearBackwards()){
				c.gearDrive.set(-0.3);
			}
			else if(controls.gearForward() != true){
				c.gearDrive.set(0);
			}
			// 
			// 
		
		}
			catch (Exception e){
				e.printStackTrace();
			}
			}
			
		}
	

