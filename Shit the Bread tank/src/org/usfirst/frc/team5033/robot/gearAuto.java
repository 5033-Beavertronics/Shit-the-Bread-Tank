
package org.usfirst.frc.team5033.robot;



public class gearAuto extends AutoMethods {
	int toggle = 0;

	public gearAuto(Componants c) {
		super(c);
	}

	public void run() throws AutoEndException {
		if(toggle != 1){
		    //driving(20.61);
			//driving(-10.61);
		   // gyroCentering();
		   gyroRotate(90, .5);
		   gyroRotate(-90, .5);
		    //gyroTurning(180);
		    //gyroTurning(-180);
		    //driving(-50.01);
		    //driving(-50.01);
		    
			gyroCentering();
			toggle = 1;
		}
	
			
		
		}

	    
	}

