package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.RobotMap;
import org.usfirst.frc.team5546.robot.commands.CheckWinch;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
    VictorSP winchMotor;
    
    public Winch() {
    	winchMotor = new VictorSP(RobotMap.WINCH_MOTOR);
    	winchMotor.setInverted(true);
    }
    
    public void trickle() {
    	winchMotor.set(0.05);
    }
    
    public void set(double speed) {
    	winchMotor.set(speed);
    }
    
    public void set(double speed, double seconds) {
		set(speed);
		Timer.delay(seconds);
		set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CheckWinch());
    }
}

