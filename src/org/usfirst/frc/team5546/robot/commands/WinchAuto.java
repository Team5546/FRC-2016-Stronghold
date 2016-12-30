package org.usfirst.frc.team5546.robot.commands;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchAuto extends Command {

	double speed, seconds;
	
    public WinchAuto(double speed, double seconds) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.winch);
        this.speed = speed;
        this.seconds = seconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winch.set(0.5, 5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
