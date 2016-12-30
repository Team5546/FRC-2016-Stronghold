package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.commands.CheckLift;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid lift;
	
	public Lift() {
		lift = new DoubleSolenoid(6,7);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheckLift());
    }
    
    public void out() {
    	lift.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void in() {
    	lift.set(DoubleSolenoid.Value.kForward);
    }
    
    public void check() {
    	if(Robot.oi.liftIn.get()) {
    		lift.set(DoubleSolenoid.Value.kForward);
    	}
    	if(Robot.oi.liftOut.get()) {
    		lift.set(DoubleSolenoid.Value.kReverse);
    	}
    }
}

