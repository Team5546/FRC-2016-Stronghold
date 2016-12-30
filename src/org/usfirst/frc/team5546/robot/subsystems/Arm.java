package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.commands.CheckArm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
	public static DoubleSolenoid lift, middle;
    
    public static Solenoid sol0, sol1, sol2, sol3, sol4, sol5;
    
    public static boolean 	inTriggered = false,
							outTriggered = false,
							inJustReleased = false,
							outJustReleased = false;
    
    public Arm() {
    	middle = new DoubleSolenoid(1,0); 	
    	sol2 = new Solenoid(2);
    	sol3 = new Solenoid(3);
    	sol4 = new Solenoid(4);
    	sol5 = new Solenoid(5);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheckArm());
    }
    
    public void goIn() {
    	sol5.set(true);
    	sol4.set(false);
    	middle.set(DoubleSolenoid.Value.kReverse);
    	sol3.set(true);
    	sol2.set(false);
    }
    
    public void goIn(double seconds) {
    	goOut();
    	
    	Timer.delay(seconds);    	
    	holdIn();
    }
    
    public void holdIn() {
    	sol5.set(false);
    	sol4.set(true);
    	sol3.set(false);
    	sol2.set(true);
    }
    
    public void goOut() {
    	sol5.set(true);
    	sol4.set(false);
    	middle.set(DoubleSolenoid.Value.kForward);
    	sol3.set(true);
    	sol2.set(false);
    }
    
    public void holdOut() {
    	sol5.set(false);
    	sol4.set(true);
    	sol3.set(false);
    	sol2.set(true);
    }
    
    public void check() {
        if (Robot.oi.inButton.get() && !inTriggered) {
        	// Put compressor in "in" mode
        	sol5.set(true);
        	sol4.set(false);
        	middle.set(DoubleSolenoid.Value.kReverse);
        	sol3.set(true);
        	sol2.set(false);
        	inTriggered = true;
        } else if (!Robot.oi.inButton.get() && inTriggered) {
        	// In has been released but has not been set
        	sol5.set(false);
        	sol4.set(true);
        	sol3.set(false);
        	sol2.set(true);
        	inTriggered = false;        	
        } else if (Robot.oi.outButton.get() && !outTriggered) {
        	// Put compressor in "out" mode
        	sol5.set(true);
        	sol4.set(false);
        	middle.set(DoubleSolenoid.Value.kForward);
        	sol3.set(true);
        	sol2.set(false);
        	outTriggered = true;
        } else if (!Robot.oi.outButton.get() && outTriggered) {
        	// Out has been released but has not been set
        	sol5.set(false);
        	sol4.set(true);
        	sol3.set(false);
        	sol2.set(true);
        	outTriggered = false;
        }
    }
    	
//    	// I don't know what this does...
//    	if(inButton.get()){
//    		middle.set(DoubleSolenoid.Value.kForward);
//    	} else if(outButton.get()){
//    		middle.set(DoubleSolenoid.Value.kReverse);
//    	}
    
}

