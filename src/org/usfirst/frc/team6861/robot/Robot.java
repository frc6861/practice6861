/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6861.robot;

import org.usfirst.frc.team6861.robot.commands.CenterAuton;
import org.usfirst.frc.team6861.robot.commands.CrossLineAuton;
import org.usfirst.frc.team6861.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6861.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	private OI m_oi;
	private  DriveTrain driveTrain;
	private Ramp ramp;
	//private boolean isInAuton;
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	@Override
	public void robotInit() {
		m_oi = new OI();
		driveTrain=new DriveTrain(m_oi);
		ramp=new Ramp(m_oi);
		m_oi.Init();
		CameraServer.getInstance().startAutomaticCapture();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		m_chooser = new SendableChooser();
		m_chooser.addObject("DriveStraightAuton", new CrossLineAuton(6,driveTrain));
		m_chooser.addDefault("SwitchAuton", new CenterAuton(2,driveTrain, m_oi));
		SmartDashboard.putData("Autonomous mode chooser", m_chooser);
		SmartDashboard.putBoolean("Proximity Sensor Left", m_oi.getLeftProximitySensor().get());
    	SmartDashboard.putBoolean("Proximity Sensor Right", m_oi.getRightProximitySensor().get());
    	SmartDashboard.putBoolean("Proximity Sensor Top", m_oi.getConveyorSensor().get());
		
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}
	

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();
		m_autonomousCommand = m_chooser.getSelected();
		//isInAuton = true;
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		//isInAuton = false;
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	public DriveTrain getDriveTrain() {
		return driveTrain;
	}

	public void setDriveTrain(DriveTrain driveTrain) {
		this.driveTrain = driveTrain;
	}

	public OI getM_oi() {
		return m_oi;
	}

	public void setM_oi(OI m_oi) {
		this.m_oi = m_oi;
	}
	
	//public boolean getIsInAuton() {
	//	return isInAuton;
	//}
	
	//public void setIsInAuton(boolean isInAuton) {
	//	this.isInAuton = isInAuton;
	//}

}
