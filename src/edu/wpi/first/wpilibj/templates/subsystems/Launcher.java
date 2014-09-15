/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.StopLauncher;

/**
 *
 * @author Developer
 */

 

public class Launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    DigitalInput launcherSwitch = new DigitalInput(RobotMap.Launcher);
    
    
    Talon launcherTalon = new Talon(RobotMap.Launcher_Talon);
    Timer timer = new Timer();
    double launcherSpeed = -.8;
    double runTime = .65; 
    boolean init = true;
    boolean switchTriggered = false;
    
    
    
    public void nudge(){
        launcherTalon.set(launcherSpeed);
    }
    
    public void stop(){
        launcherTalon.set(0);
    }
    
    public boolean launch (){
    
        if(launcherSwitch.get() || switchTriggered){
        launcherTalon.set(launcherSpeed);
        
            if(switchTriggered && launcherSwitch.get()){
                
                switchTriggered = false;
                launcherTalon.set(0);
                return true;

            }
        
        }else{

            switchTriggered = true;
            
        }
       
        
    
        return false;
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        

        }
    
}

