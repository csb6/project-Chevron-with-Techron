package org.usfirst.frc.team6530.robot.commands;

import org.usfirst.frc.team6530.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class getNavX extends Command {

	 public getNavX() {
	    	requires(Robot.SUB_GYRO);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	SmartDashboard.putNumber("NavX Angle", Robot.SUB_GYRO.getAngle());
	    	System.out.println(Robot.SUB_GYRO.getAngle());
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
	}