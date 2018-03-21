package org.usfirst.frc.team6861.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RotateUsingPigeonIMU extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	PigeonIMU _pidgey;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	_pidgey = new PigeonIMU(0); /* Pigeon is on CANBus (powered from ~12V, and has a device ID of zero */
    }
}

