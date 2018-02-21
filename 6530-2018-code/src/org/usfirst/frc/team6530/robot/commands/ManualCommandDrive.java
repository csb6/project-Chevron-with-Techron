//package org.usfirst.frc.team6530.robot.commands;
//
//import edu.wpi.first.wpilibj.command.Command;
//
//import org.usfirst.frc.team6530.robot.OI;
//import org.usfirst.frc.team6530.robot.Robot;
//import edu.wpi.first.wpilibj.Joystick;
//
///**
// * An example command.  You can replace me with your own command.
// */
//public class ManualCommandDrive extends Command {
//	public ManualCommandDrive() {
//		// Use requires() here to declare subsystem dependencies
//		requires(Robot.SUB_DRIVE);
//	}
//
//	// Called just before this Command runs the first time
//	@Override
//	protected void initialize() {
//		Robot.SUB_DRIVE.setDriveValue(0, 0);
//	}
//
//	// Called repeatedly when this Command is scheduled to run
//	@Override
//	protected void execute() {
//		Robot.SUB_DRIVE.DriveWithJoystick(OI.DRIVER);  //we have 3 drive modes, DriveWithJoystick, driveForza, driveRLTank
//	}
//
//	// Make this return true when this Command no longer needs to run execute()
//	@Override
//	protected boolean isFinished() {
//		return false;
//	}
//
//	// Called once after isFinished returns true
//	@Override
//	protected void end() {
//		exit();
//	}
//
//	// Called when another command which requires one or more of the same
//	// subsystems is scheduled to run
//	@Override
//	protected void interrupted() {
//		exit();
//	}
//	
//	private void exit() {
//		Robot.SUB_DRIVE.setDriveValue(0, 0);
//	}
//}