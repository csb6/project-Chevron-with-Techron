<<<<<<< HEAD
package org.usfirst.frc.team6530.robot.subsystems;

import org.usfirst.frc.team6530.robot.Constants;
import org.usfirst.frc.team6530.robot.auto.components.AutoRoller;
import org.usfirst.frc.team6530.robot.commands.commandRoller;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class subsystemRoller extends Subsystem {

    Spark leftRollMotor = new Spark(Constants.PWM_INTAKE_LEFT);
    Spark rightRollMotor = new Spark(Constants.PWM_INTAKE_RIGHT);
    
    public void intake(double speed) {
    	rightRollMotor.set(-speed);
    	leftRollMotor.set(speed);
    }
    
    public void spit(double speed) {
    	rightRollMotor.set(-speed);
    	leftRollMotor.set(speed);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	if(DriverStation.getInstance().isAutonomous() ) {
    		setDefaultCommand(new AutoRoller() );
    	}
    	else if(DriverStation.getInstance().isOperatorControl() ){
    		setDefaultCommand(new commandRoller() );
    	}
    }
}

=======
package org.usfirst.frc.team6530.robot.subsystems;

import org.usfirst.frc.team6530.robot.Constants;
import org.usfirst.frc.team6530.robot.commands.ManualCommandDrive;
import org.usfirst.frc.team6530.robot.commands.commandRoller;
import org.usfirst.frc.team6530.robot.util.Xbox;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the collector/fidget spinner motors.
 */
public class subsystemRoller extends Subsystem {
	Spark rightCollectorMotor = new Spark(Constants.PWM_INTAKE_RIGHT);
	Spark leftCollectorMotor = new Spark(Constants.PWM_INTAKE_LEFT);



/** apply left motor invert */
public static final double leftify(double left) {
	return left * (Constants.LEFT_MOTOR_INVERT ? -1.0 : 1.0);
}
/** apply right motor invert */
public static final double rightify(double right) {
	return right * (Constants.RIGHT_MOTOR_INVERT ? -1.0 : 1.0);
}
public void initDefaultCommand() {
	setDefaultCommand(new commandRoller());
}
	public void RollerDrive(Joystick joy) {
    	
    	double left = Xbox.LT(joy);
    	double right = Xbox.RT(joy);
    	
    	//Quick Truncate
    	left = (left > 1.0 ? 1.0 : (left < -1.0 ? -1.0 : left));
    	right = (right > 1.0 ? 1.0 : (right < -1.0 ? -1.0 : right));
    	    	
    	rightCollectorMotor.set(rightify(right));
    		leftCollectorMotor.set(leftify(left));
	}
	// The speeds are negative for intake and outtake since the motors need to spin
	// in opposite directions
	// intake spins the motors towards the inside of the collector and outtake spins
	// the motors away from the collector
	public void intake() {
		leftCollectorMotor.set(1);
		rightCollectorMotor.set(-1);

	}

	// The outtake speed is slower so the power cubes do not fly uncontrollably out
	// of the collector
	public void outtake() {
		leftCollectorMotor.set(-1);
		rightCollectorMotor.set(1);
	}

}
>>>>>>> 25e74701eda88e1bf24dfe240d0a4be03f40eec1