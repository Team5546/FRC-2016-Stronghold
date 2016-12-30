package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
    public static VictorSP frontLeftMotor,
							rearLeftMotor, 
							frontRightMotor, 
							rearRightMotor;
	RobotDrive drive;
	
	int autoLoopCounter = 0;
	
	public DriveTrain(){
		frontLeftMotor = new VictorSP(4);
    	rearLeftMotor = new VictorSP(3);
    	frontRightMotor = new VictorSP(5);
    	rearRightMotor = new VictorSP(2);
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		drive.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    
    public void driveTank(double left, double right, boolean squared) {
    	drive.tankDrive(-left, -right, squared);
    }
    
    public void driveArcade(double move, double rotate, boolean squared) {
    	drive.arcadeDrive(move, rotate, squared);
    }
    
    public void driveAuto(double left, double right, double seconds) {
		driveTank(left, right, false); 	// drive forwards half speed
		Timer.delay(seconds);
		driveTank(0, 0, false); 	// stop robot
    }
    
    public void stop() {
    	drive.stopMotor();
    }
}

