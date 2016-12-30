package org.usfirst.frc.team5546.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public Joystick controller = new Joystick(0);
    public Joystick leftJoystick = new Joystick(1);
    public Joystick rightJoystick = new Joystick(2);
    //public Joystick launchpad = new Joystick(3);
    
    // ** Buttons **
    //public Button compressorButton = new JoystickButton(launchpad, 2);
    public Button inButton = new JoystickButton(controller, 4);
    public Button outButton = new JoystickButton(controller, 1);
    public Button liftOut = new JoystickButton(controller, 2);
    public Button liftIn = new JoystickButton(controller, 3);
    
    public Button retractSucker = new JoystickButton(rightJoystick, 1);
    
    // ** Triggers **
    public OI() {
//    	inButton.whileHeld(new GoIn());
//    	inButton.whenReleased(new HoldIn());
//    	outButton.whileHeld(new GoOut());
//    	outButton.whenReleased(new HoldOut());
    	
    	//compressorButton.whenPressed(new CompressorOff());
    	//compressorButton.whenReleased(new CompressorOn());
    	
    	//liftOut.whenPressed(new LiftOut());
    	//liftIn.whenPressed(new LiftIn());
    	
//    	retractSucker.whenPressed(new );
//    	retractSucker.whenReleased(new );
    }
    
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

