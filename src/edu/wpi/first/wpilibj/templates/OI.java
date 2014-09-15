
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CatapultFree;
import edu.wpi.first.wpilibj.templates.commands.CatapultLower;
import edu.wpi.first.wpilibj.templates.commands.CatapultManual;
import edu.wpi.first.wpilibj.templates.commands.LaunchSequence;
import edu.wpi.first.wpilibj.templates.commands.NudgeLauncher;
import edu.wpi.first.wpilibj.templates.commands.PassSequence;
import edu.wpi.first.wpilibj.templates.commands.PickupDown;
import edu.wpi.first.wpilibj.templates.commands.PickupUp;
import edu.wpi.first.wpilibj.templates.commands.ReloadSequence;
import edu.wpi.first.wpilibj.templates.commands.ShiftHigh;
import edu.wpi.first.wpilibj.templates.commands.StopLauncher;

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
        shiftHigh.whileHeld(new ShiftHigh());
        
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

