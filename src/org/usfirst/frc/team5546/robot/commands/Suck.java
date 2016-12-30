package org.usfirst.frc.team5546.robot.commands;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Suck extends Command {

	double speed = 0;
	
    public Suck() {
        requires(Robot.ballSucker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed = Robot.oi.controller.getRawAxis(RobotMap.SUCK_AXIS);
    	
    	if(Math.abs(speed) < 0.2) {
    		Robot.ballSucker.set(0.0);
    	} else {
    		Robot.ballSucker.set(Robot.oi.controller.getRawAxis(RobotMap.SUCK_AXIS));
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
