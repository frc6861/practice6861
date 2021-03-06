package org.usfirst.frc.team6861.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Conveyor extends Subsystem {
	private Spark conveyorLeft;
	private Spark conveyorRight;
	private DigitalInput conveyorSensor;
     //Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public DigitalInput getConveyorSensor() {
		return conveyorSensor;
	}

	public void setConveyorSensor(DigitalInput conveyorSensor) {
		this.conveyorSensor = conveyorSensor;
	}

	public Conveyor() {
		conveyorLeft = new Spark(4);
		conveyorRight = new Spark(6);
	
	}

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void driveConveyor(double speed) {
    	conveyorLeft.set(-speed);
    	conveyorRight.set(speed);
    }
}

