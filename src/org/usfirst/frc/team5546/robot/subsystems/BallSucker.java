package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.RobotMap;
import org.usfirst.frc.team5546.robot.commands.Suck;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallSucker extends Subsystem {
	
	VictorSP leftCounter, rightCounter;
	
	public BallSucker() {
		// ha ha ha
		leftCounter = new VictorSP(RobotMap.LEFT_COUNTER_MOTOR);
		rightCounter = new VictorSP(RobotMap.RIGHT_COUNTER_MOTOR);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new Suck());
    }
    
    public void set(double speed) {
    	leftCounter.set(-speed);
    	rightCounter.set(speed);
    }
}

