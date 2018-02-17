package org.usfirst.frc.team6861.robot.commands;

import org.usfirst.frc.team6861.robot.OI;
import org.usfirst.frc.team6861.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {
    public Shoot(OI m_oi) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.driveShooter(1);
    	//Robot.conveyor.driveConveyor(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.driveShooter(0);
    	//Robot.conveyor.driveConveyor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.driveShooter(0);
    	//Robot.conveyor.driveConveyor(0);
    }
}
