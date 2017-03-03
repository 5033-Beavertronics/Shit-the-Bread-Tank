
package org.usfirst.frc.team5033.robot;



public class TestAuto extends AutoMethods {
	int toggle = 0;



	public TestAuto(Componants c) {
		super(c);
	}

	public void run() throws AutoEndException {
		while(toggle != 1){
		    driving(20.61);
			//gyroCentering();
		    driving(-10.61);
		    //gyroCentering();
		    //straight(1, 100);
		    //driving(0);

			//straight(-1, -100);
			toggle = 1;

			//driving(121.61);
			//gyroCentering();
			//driving(120.25);
						
		
	    
	}
}
}
