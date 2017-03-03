package org.usfirst.frc.team5033.robot;

import org.usfirst.frc.team5033.robot.define.AutonomousRoutines;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
@SuppressWarnings("unused")

public class Auto {
	Componants c;
	AutoMethods auto;
	define.AutonomousRoutines routines;

	public void initializeSmartDashBoard() {

	}
	

	public void run(AutonomousRoutines routines, Componants c) throws AutoEndException {
		routines = (define.AutonomousRoutines) c.chooser.getSelected();

		switch (routines) {
		case TEST_AUTO:
			auto = new TestAuto(c);
			break;
		case NUMBER_2:
			auto = new gearAuto(c);// second autonomous choice
			break;
		case GEAR_AUTO:
			auto = new gearAuto(c);
			break;
		}
		auto.run();
	}


}