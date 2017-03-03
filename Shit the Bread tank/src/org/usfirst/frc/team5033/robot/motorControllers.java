package org.usfirst.frc.team5033.robot;
import edu.wpi.first.wpilibj.TalonSRX;
import java.util.function.BooleanSupplier;



public class motorControllers{
	Controls controls = new Controls();
	
	TalonSRX talonsrx;
	

	BooleanSupplier forward;
	BooleanSupplier backward;
	public motorControllers(BooleanSupplier forward,BooleanSupplier backward, TalonSRX talonsrx) {
		this.forward = forward;
		this.backward = backward;
		this.talonsrx = talonsrx;
	
	
	}

	public void update(){
		if (forward.getAsBoolean()) {
			talonsrx.set(define.MOTOR_FULL_SPEED_FORWARD);
		} else if (backward.getAsBoolean()) {
			talonsrx.set(define.MOTOR_FULL_SPEED_REVERSE);
		} else {
			talonsrx.set(define.MOTOR_OFF);
		}
	}
}
	