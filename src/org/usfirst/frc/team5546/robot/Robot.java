
package org.usfirst.frc.team5546.robot;

import org.usfirst.frc.team5546.robot.commands.CompressorOn;
import org.usfirst.frc.team5546.robot.commands.Drive;
import org.usfirst.frc.team5546.robot.commands.DriveOverDefenses;
import org.usfirst.frc.team5546.robot.commands.DriveOverDefensesWithArmDown;
import org.usfirst.frc.team5546.robot.subsystems.Arm;
import org.usfirst.frc.team5546.robot.subsystems.BallSucker;
import org.usfirst.frc.team5546.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5546.robot.subsystems.Lift;
import org.usfirst.frc.team5546.robot.subsystems.PneumaticCompressor;
import org.usfirst.frc.team5546.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final BallSucker ballSucker = new BallSucker();
	public static final Winch winch = new Winch();
	public static final Arm arm = new Arm();
	public static final Lift lift = new Lift();
	public static final PneumaticCompressor pneumaticCompressor = new PneumaticCompressor();
	public static CompressorOn compressorOn = new CompressorOn();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    public static MultiCameraServer camera;
    
    public Servo servo;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Drive over defenses", new DriveOverDefenses());
        chooser.addObject("Drive over defenses and put down arm", new DriveOverDefensesWithArmDown());
        chooser.addObject("None", null);
        SmartDashboard.putData("Auto mode", chooser);
        
        camera = new MultiCameraServer(1);
		
	    camera.setCamera(0);
	    
//	    pneumaticCompressor.start();
//	    pneumaticCompressor.compressor.start();
//	    compressorOn.setRunWhenDisabled(true);
//    	compressorOn.start();
	    
	    servo = new Servo(9);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
//    	compressorOn.setRunWhenDisabled(true);
//    	compressorOn.start();
    }
	
	public void disabledPeriodic() {
		
		Scheduler.getInstance().run();
		camera.run();
    	if(oi.leftJoystick.getRawButton(1)) {
    		camera.setCamera(1);
    	}
    	if(oi.rightJoystick.getRawButton(1)){
    		camera.setCamera(0);
    	}   	
    	
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
    	//autonomousCommand = new DriveOverDefenses();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        camera.run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        new Drive();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

    	camera.run();
    	
//    	if(oi.leftJoystick.getRawButton(1)) {
//    		camera.setCamera(1);
//    	}
//    	if(oi.rightJoystick.getRawButton(1)){
//    		camera.setCamera(0);
//    	}
        
        if(oi.rightJoystick.getRawButton(1)){
    		servo.setAngle(180);
    	} else {
    		servo.setAngle(10);
    	}
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
