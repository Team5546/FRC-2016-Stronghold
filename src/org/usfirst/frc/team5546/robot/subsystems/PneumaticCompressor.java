package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.commands.CompressorOn;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticCompressor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Compressor compressor;
	
	public PneumaticCompressor() {
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CompressorOn());
    }
    
    // Set compressor on or off based on compressor button
//    public void updateCompressorStatus() {
//    	if(Robot.oi.compressorButton.get() && compressor.enabled()) {
//    		compressor.stop();
//    	} else if(!Robot.oi.compressorButton.get() && !compressor.enabled()) {
//    		compressor.start();
//    	}
//    }
    
    public void start() {
    	compressor.start();
    }
    
    public void stop() {
    	compressor.stop();
    }
}

