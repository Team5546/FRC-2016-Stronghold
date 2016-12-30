package org.usfirst.frc.team5546.robot.commands;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheckWinch extends Command {
	
	double speed = 0;
	final double DEAD_ZONE = 0.2;

    public CheckWinch() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed = Robot.oi.controller.getRawAxis(RobotMap.WINCH_AXIS);
    	if(Math.abs(speed) < DEAD_ZONE) {
    		Robot.winch.trickle();
    	} else {
    		Robot.winch.set(speed);
    	}
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
