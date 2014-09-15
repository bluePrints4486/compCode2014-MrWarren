
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// MrWarren - By importing "commands.*" here, it gives you access to any
// commands this file might use rather than having to import each
// individual command
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final Joystick leftJoystick = new Joystick (RobotMap.Left_Stick) ;
    public static final Joystick rightJoystick = new Joystick (RobotMap.Right_Stick) ;
    public static final Joystick systemsJoystick = new Joystick (RobotMap.Systems_Stick) ;
   
    public static final JoystickButton shiftHigh = new JoystickButton(rightJoystick,1);
    
    public static final JoystickButton launch = new JoystickButton(systemsJoystick,1);
    public static final JoystickButton lowerPickup = new JoystickButton(systemsJoystick,2);
    public static final JoystickButton raisePickup = new JoystickButton(systemsJoystick,3);
    public static final JoystickButton nudgeLauncher = new JoystickButton(systemsJoystick,4);
    public static final JoystickButton pass = new JoystickButton(systemsJoystick,5);
    public static final JoystickButton lowerCatapult = new JoystickButton(systemsJoystick,6);
    public static final JoystickButton raiseCatapult = new JoystickButton(systemsJoystick,7);
    public static final JoystickButton reload = new JoystickButton(systemsJoystick,8);
    public static final JoystickButton freeCatapult = new JoystickButton(systemsJoystick,9);
    
    public OI(){
        // MrWarren - Previously the code executed the ShiftHigh command
        // while the shiftHigh button was held. The shiftLow command was the
        // default command for the ShiftersSub subsysystem. This worked becaause
        // once the button was no longer held, it would interrupt the ShiftHigh
        // command and start a new execution of the ShiftLow command. However,
        // the code was not very readable because you had to look at lot of
        // places to make sure the ShiftLow command was being executed somewhere.
        // It is cleaner to write the code as below to show that when the button
        // is pressed, it shifts into high gear, and when the button is released
        // it shifts into low gear.
        shiftHigh.whenPressed(new ShiftHigh());
        shiftHigh.whenReleased(new ShiftLow());
        
        launch.whenPressed(new LaunchSequence());
        
        lowerPickup.whileHeld(new PickupDown());
        raisePickup.whileHeld(new PickupUp());
        
        nudgeLauncher.whileHeld(new NudgeLauncher());
        nudgeLauncher.whenReleased(new StopLauncher());
        reload.whenPressed(new ReloadSequence());
        
        pass.whenPressed(new PassSequence());
        freeCatapult.whenPressed(new CatapultFree());
        
        lowerCatapult.whileHeld(new CatapultManual(true));
        raiseCatapult.whileHeld(new CatapultManual(false));
        
    }
    
}

