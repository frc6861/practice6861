package org.usfirst.frc.team6861.robot.commands;

import org.usfirst.frc.team6861.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CrossLineAuton extends TimedCommand {

    private DriveTrain driveTrain;

	public CrossLineAuton(double timeout,DriveTrain driveTrain) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        this.driveTrain=driveTrain;
        requires(driveTrain);
    }

    // Called just  before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.setMecanumDriveCommand(0, -0.3, 0, 0);
  
    }

    // Called once after timeout
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
